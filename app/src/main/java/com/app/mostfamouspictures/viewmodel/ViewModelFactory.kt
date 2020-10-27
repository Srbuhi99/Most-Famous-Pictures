package com.app.mostfamouspictures.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.mostfamouspictures.repository.FirebaseRepo
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PicturesListViewModel::class.java)){
            return PicturesListViewModel(FirebaseRepo()) as T
        }

        if(modelClass.isAssignableFrom(ArtistsListViewModel::class.java)){
            return ArtistsListViewModel(FirebaseRepo()) as T
        }

        throw  IllegalArgumentException("Unknown class name")

    }
}