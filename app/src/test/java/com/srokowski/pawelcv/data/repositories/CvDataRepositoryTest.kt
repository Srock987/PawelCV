package com.srokowski.pawelcv.data.repositories

import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.srokowski.pawelcv.BlockingTest
import com.srokowski.pawelcv.data.dataSources.CvLocalDataSource
import com.srokowski.pawelcv.data.dataSources.CvRemoteDataSource
import com.srokowski.pawelcv.data.dataSources.SharedPreferencesIdStorage
import com.srokowski.pawelcv.data.entities.CvData
import com.srokowski.pawelcv.testCvData
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

@ExperimentalCoroutinesApi
class CvDataRepositoryTest: BlockingTest() {

    @RelaxedMockK
    lateinit var local: CvLocalDataSource
    @RelaxedMockK
    lateinit var remote: CvRemoteDataSource
    @RelaxedMockK
    lateinit var storage: SharedPreferencesIdStorage
    @RelaxedMockK
    lateinit var dataObserver: Observer<Result<CvData>>

    lateinit var subject: CvDataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        subject = CvDataRepository(local, remote, storage)
    }

    @Test
    fun `Given valid local and remote, When getCvData called, Then only local data emitted`() = runSuspendTestBlock{
        val id = 1
        val cvData = testCvData
        coEvery { storage.getStoredCvId() } coAnswers { id }
        coEvery { local.getLocalCvData(id) } coAnswers { cvData }
        coEvery { remote.fetchCvData() } coAnswers { cvData }
        val result = subject.getCvData()
        result.asLiveData(testDispatcher).observeForever(dataObserver)
        coVerify(exactly = 1) { local.getLocalCvData(id) }
        coVerify(exactly = 1) { remote.fetchCvData() }
        coVerify(exactly = 0) { local.saveCvData(any()) }
        coVerify(exactly = 1) { dataObserver.onChanged(Result.success(cvData)) }
        confirmVerified(local, remote, dataObserver)
    }

    @Test
    fun `Given invalid local and valid remote, When getCvData called, Then remote data emitted and cashed`() = runSuspendTestBlock{
        val id = 1
        val cvData = testCvData
        coEvery { storage.getStoredCvId() } coAnswers { id }
        coEvery { local.getLocalCvData(id) } coAnswers { null }
        coEvery { local.saveCvData(any()) } coAnswers { Unit }
        coEvery { remote.fetchCvData() } coAnswers { cvData }
        val result = subject.getCvData()
        result.asLiveData(testDispatcher).observeForever(dataObserver)
        coVerify(exactly = 1) { local.saveCvData(cvData) }
        coVerify(exactly = 1) { local.getLocalCvData(id) }
        coVerify(exactly = 1) { local.saveCvData(any()) }
        coVerify(exactly = 1) { remote.fetchCvData() }
        coVerify(exactly = 1) { dataObserver.onChanged(Result.success(cvData)) }
        confirmVerified(local, remote, dataObserver)
    }

    @Test
    fun `Given old local and updated remote data, When getCvData called, Then local emitted then remote emitted and cashed`() = runSuspendTestBlock {
        val id = 1
        val cvData = testCvData
        val updatedData = cvData.copy(name = "new")
        coEvery { storage.getStoredCvId() } coAnswers { id }
        coEvery { local.getLocalCvData(id) } coAnswers { cvData }
        coEvery { local.saveCvData(any()) } coAnswers { Unit }
        coEvery { remote.fetchCvData() } coAnswers { updatedData }
        val result = subject.getCvData()
        result.asLiveData(testDispatcher).observeForever(dataObserver)
        coVerify(exactly = 1) { local.saveCvData(updatedData) }
        coVerify(exactly = 1) { local.getLocalCvData(id) }
        coVerify(exactly = 1) { remote.fetchCvData() }
        coVerify(exactly = 1) { dataObserver.onChanged(Result.success(cvData)) }
        coVerify(exactly = 1) { dataObserver.onChanged(Result.success(updatedData)) }
        confirmVerified(local, remote, dataObserver)
    }

    @Test
    fun `Given invalid local and remote data, When getCvData called, Then only network error emitted`() = runSuspendTestBlock {
        val id = 1
        coEvery { storage.getStoredCvId() } coAnswers { id }
        coEvery { local.getLocalCvData(id) } coAnswers { null }
        coEvery { local.saveCvData(any()) } coAnswers { Unit }
        coEvery { remote.fetchCvData() } coAnswers { null }
        val result = subject.getCvData()
        result.asLiveData(testDispatcher).observeForever(dataObserver)
        coVerify(exactly = 0) { local.saveCvData(any()) }
        coVerify(exactly = 1) { local.getLocalCvData(id) }
        coVerify(exactly = 1) { remote.fetchCvData() }
        coVerify(exactly = 1) { dataObserver.onChanged(Result.failure(NetworkException)) }
        confirmVerified(local, remote, dataObserver)
    }
}