package com.tiago.instagramclone.data.source

import com.google.firebase.firestore.FirebaseFirestore

class DataSource {
    private val db = FirebaseFirestore.getInstance()
    fun salvarPost(
        userNickname: String,
        localName: String,
        userAvatar: String,
        imageUrl: String,
        description: String,
        postedAgo: String)
    {
        val postMap = hashMapOf(
            "userNickname" to userNickname,
            "localName" to localName,
            "userAvatar" to userAvatar,
            "imageUrl" to imageUrl,
            "description" to description,
            "postedAgo" to postedAgo

        )


        db.collection("posts").document(userNickname).set(postMap).addOnCompleteListener {

        }.addOnFailureListener {

        }

    }
}