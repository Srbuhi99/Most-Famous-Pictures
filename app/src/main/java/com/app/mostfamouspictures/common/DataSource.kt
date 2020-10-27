package com.app.mostfamouspictures.common

import com.app.mostfamouspictures.model.Artist
import com.app.mostfamouspictures.model.Picture

interface DataSource {

    suspend fun getPictures() : List<Picture>

    suspend fun getArtists() : List<Artist>
}