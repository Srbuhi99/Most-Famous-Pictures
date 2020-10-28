package com.app.mostfamouspictures.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mostfamouspictures.model.Picture
import com.app.mostfamouspictures.repository.FirebaseRepo
import kotlinx.coroutines.launch

class DetailPictureViewModel(private var firebaseRepo: FirebaseRepo): ViewModel(){

    var picture:MutableLiveData<Picture> = MutableLiveData()

     fun fetch(imageId:String){
         viewModelScope.launch {
             picture.value = firebaseRepo.getPicture(imageId)
         }
     }
}