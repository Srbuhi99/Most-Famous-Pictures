package com.example.mostfamouspictures.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mostfamouspictures.model.Artist
import com.example.mostfamouspictures.repository.FirebaseRepo
import kotlinx.coroutines.launch
import java.util.ArrayList

class ArtistsListViewModel(private var firebaseRepo: FirebaseRepo):ViewModel() {

    var artistsList:MutableLiveData<ArrayList<Artist>> = MutableLiveData()

    init {
        viewModelScope.launch {
            artistsList.value = firebaseRepo.getArtists() as ArrayList<Artist>
        }
    }

    fun getartistsList(): MutableLiveData<ArrayList<Artist>>{
        return artistsList
    }
}