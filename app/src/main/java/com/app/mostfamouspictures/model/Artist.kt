package com.app.mostfamouspictures.model

import com.google.firebase.firestore.PropertyName

data class Artist(
    @set:PropertyName("artist_id") @get:PropertyName("artist_id") var artistId:String,
    @set:PropertyName("artist_name") @get:PropertyName("artist_name") var artistName:String,
    var url: String,
    var biography: String,
    var art: String,
    @set:PropertyName("personal_life") @get:PropertyName("personal_life") var personalLife:String,
    var education:String,
    var lifetime:String
    ){
    constructor():this("","","","","","","","")
}