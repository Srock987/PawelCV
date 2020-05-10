package com.srokowski.pawelcv.presentation.shared

import android.util.Log
import androidx.lifecycle.*
import com.srokowski.pawelcv.data.entities.CvData
import com.srokowski.pawelcv.data.entities.Education
import com.srokowski.pawelcv.data.entities.Experience
import com.srokowski.pawelcv.presentation.skill.SkillViewDataItemFactory
import com.srokowski.pawelcv.presentation.skill.SkillViewData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CvSharedViewModel(
    private val model: CvModelContract.Model,
    private val skillsFactory: SkillViewDataItemFactory
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

    fun getEducation(): LiveData<List<Education>>{
        return Transformations.map(cvData){ data -> data.education}
    }

    fun getSkillViewData(): LiveData<List<SkillViewData>>{
        return Transformations.map(cvData){ data -> skillsFactory.create(data.skills) }
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