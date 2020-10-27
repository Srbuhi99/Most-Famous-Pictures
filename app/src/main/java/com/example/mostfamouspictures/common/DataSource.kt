package com.example.mostfamouspictures.common

import com.example.mostfamouspictures.model.Artist
import com.example.mostfamouspictures.model.Picture

interface DataSource {

    suspend fun getPictures() : List<Picture>

    suspend fun getArtists() : List<Artist>
}