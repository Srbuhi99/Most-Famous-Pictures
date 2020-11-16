package com.app.mostfamouspictures.model

import com.google.firebase.firestore.PropertyName

data class Artist(

        var art: String,
        var url: String,
        var lifetime:String,
        var biography: String,
        var education:String,
        @set:PropertyName("artist_id") @get:PropertyName("artist_id") var artistId:String,
        @set:PropertyName("artist_name") @get:PropertyName("artist_name") var artistName:String,
        @set:PropertyName("personal_life") @get:PropertyName("personal_life") var personalLife:String
    ){
    constructor():this("","","","","","","","")
}