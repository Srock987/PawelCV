package com.srokowski.pawelcv.presentation

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.srokowski.pawelcv.data.entities.CvData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CvSharedViewModel(
    private val model: CvModelContract.Model
): ViewModel() {

    val cvData = MediatorLiveData<CvData>()

    private fun fetchCvData(){
        viewModelScope.launch(Dispatchers.IO){
            cvData.addSource(model.getCvData().asLiveData(Dispatchers.IO)){
                it.fold(
                    onSuccess = {
                        cvData.postValue(it)
                    },
                    onFailure = {

                    }
                )
            }
        }
    }
}