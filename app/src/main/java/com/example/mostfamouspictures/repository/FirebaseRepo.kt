package com.example.mostfamouspictures.repository

import com.example.mostfamouspictures.common.DataSource
import com.example.mostfamouspictures.model.Artist
import com.example.mostfamouspictures.model.Picture
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseRepo: DataSource {

    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }

    override suspend fun getPictures(): List<Picture> =
        suspendCoroutine { cont ->
            firestoreInstance.collection("pictures")
                .get()
                .addOnSuccessListener {
                    cont.resume(it.toObjects(Picture::class.java))
                }
        }



    override suspend fun getArtists(): List<Artist> =
        suspendCoroutine {cont ->
            firestoreInstance.collection("artist")
                .get()
                .addOnSuccessListener {
                    cont.resume(it.toObjects(Artist::class.java))
                }
                .addOnFailureListener {
                    it.message
                }

        }

}