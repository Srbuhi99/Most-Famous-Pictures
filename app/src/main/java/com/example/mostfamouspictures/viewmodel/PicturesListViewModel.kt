package com.example.mostfamouspictures.viewmodel

import android.graphics.Picture
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mostfamouspictures.repository.FirebaseRepo
import kotlinx.coroutines.launch
import java.util.ArrayList

class PicturesListViewModel(private var firebaseRepo: FirebaseRepo) : ViewModel() {

    var picturesList: MutableLiveData<ArrayList<Picture>> = MutableLiveData()

    init {
        viewModelScope.launch {
            picturesList.value = firebaseRepo.getArtists() as ArrayList<Picture>
        }
    }

    fun getartistsList(): MutableLiveData<ArrayList<Picture>> {
        return picturesList
    }
}