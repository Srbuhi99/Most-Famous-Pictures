package com.app.mostfamouspictures.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mostfamouspictures.model.Artist
import com.app.mostfamouspictures.repository.FirebaseRepo
import kotlinx.coroutines.launch

class DetailArtistViewModel(private var firebaseRepo: FirebaseRepo) : ViewModel() {


    var artist: MutableLiveData<Artist> = MutableLiveData()

    fun fetch(artistId:String){
        viewModelScope.launch {
            artist.value = firebaseRepo.getArtist(artistId)
        }
    }
}