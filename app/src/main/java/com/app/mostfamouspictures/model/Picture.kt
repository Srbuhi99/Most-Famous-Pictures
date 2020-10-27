package com.app.mostfamouspictures.model

import com.google.firebase.firestore.PropertyName

data class Picture(
    @set:PropertyName("image_id") @get:PropertyName("image_id") var imageId:String,
    @set:PropertyName("image_url") @get:PropertyName("image_url") var imageUrl:String,
    @set:PropertyName("artist_name") @get:PropertyName("artist_name") var artistName:String,
    @set:PropertyName("picture_title") @get:PropertyName("picture_title") var pictureTitle:String,
    var description:String
    ){
    constructor():this("","","","","")
}