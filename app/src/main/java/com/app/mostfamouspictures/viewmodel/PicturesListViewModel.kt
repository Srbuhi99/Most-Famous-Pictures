package com.app.mostfamouspictures.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mostfamouspictures.model.Picture
import com.app.mostfamouspictures.repository.FirebaseRepo
import kotlinx.coroutines.launch
import java.util.ArrayList

class PicturesListViewModel(private var firebaseRepo: FirebaseRepo) : ViewModel() {

    var picturesList: MutableLiveData<ArrayList<Picture>> = MutableLiveData()

    init {
        viewModelScope.launch {
            picturesList.value = firebaseRepo.getPictures() as ArrayList<Picture>
        }
    }

    fun getpicturesList(): MutableLiveData<ArrayList<Picture>> {
        return picturesList
    }
}