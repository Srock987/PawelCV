package com.srokowski.pawelcv.presentation.shared

import android.util.Log
import androidx.lifecycle.*
import com.srokowski.pawelcv.data.entities.CvData
import com.srokowski.pawelcv.data.entities.Experience
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CvSharedViewModel(
    private val model: CvModelContract.Model
): ViewModel() {

    private val cvData by lazy {
        MediatorLiveData<CvData>().also {
            fetchCvData()
        }
    }

    fun getCvDate(): LiveData<CvData> = cvData

    fun getExperience(): LiveData<List<Experience>> {
        return Transformations.map(cvData){ data -> data.experience }
    }

    private fun fetchCvData(){
        viewModelScope.launch(Dispatchers.Main){
            cvData.addSource(model.getCvData().asLiveData(Dispatchers.IO)){
                it.fold(
                    onSuccess = {
                        cvData.postValue(it)
                    },
                    onFailure = {
                        Log.e("CvSharedViewModel", "${it.message}")
                    }
                )
            }
        }
    }
}