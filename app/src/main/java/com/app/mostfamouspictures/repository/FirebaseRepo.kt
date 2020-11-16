package com.app.mostfamouspictures.repository

import com.app.mostfamouspictures.common.DataSource
import com.app.mostfamouspictures.model.Artist
import com.app.mostfamouspictures.model.Picture
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

        }

    override suspend fun getPicture(imageId: String): Picture =
        suspendCoroutine { cont->
            firestoreInstance.collection("pictures")
               .document(imageId)
                .get()
                .addOnSuccessListener {
                    cont.resume(it.toObject(Picture::class.java)!!)
                }
        }

    override suspend fun getArtist(artistId: String): Artist =
        suspendCoroutine { cont ->
            firestoreInstance.collection("artist")
                .document(artistId)
                .get()
                .addOnSuccessListener {
                    cont.resume(it.toObject(Artist::class.java)!!)
                }

        }




    }