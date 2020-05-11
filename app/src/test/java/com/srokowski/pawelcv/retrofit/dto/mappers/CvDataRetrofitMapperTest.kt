package com.srokowski.pawelcv.retrofit.dto.mappers

import com.srokowski.pawelcv.testCvData
import com.srokowski.pawelcv.testDtoData
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotEqual
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CvDataRetrofitMapperTest{

    lateinit var subject: CvDataRetrofitMapper

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        subject = CvDataRetrofitMapper(CvDataDtoValidator())
    }

    @Test
    fun `Given valid dto data, When mapToData called, Then valid object returned`(){
        val data = testDtoData
        val result = subject.mapToData(data)
        result shouldNotEqual null
        result shouldEqual testCvData
    }

    @Test
    fun `Given invalid dto data, When mapToData called, Then null returned`(){
        val data = testDtoData.copy(address = null)
        val result = subject.mapToData(data)
        result shouldEqual null
    }
}