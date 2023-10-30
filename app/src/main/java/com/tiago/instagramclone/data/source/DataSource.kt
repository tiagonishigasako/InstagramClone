package com.tiago.instagramclone.data.source

import com.google.firebase.firestore.FirebaseFirestore
import com.tiago.instagramclone.data.model.Feed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val db = FirebaseFirestore.getInstance()
    private val _todosFeed = MutableStateFlow<MutableList<Feed>>(mutableListOf())
    private val todosFeed: StateFlow<MutableList<Feed>> = _todosFeed


    fun salvarFeed(
        userNickname: String,
        localName: String,
        userAvatar: String,
        imageUrl: String,
        description: String,
        postedAgo: String
    ) {
        val feedMap = hashMapOf(
            "userNickname" to userNickname,
            "localName" to localName,
            "userAvatar" to userAvatar,
            "imageUrl" to imageUrl,
            "description" to description,
            "postedAgo" to postedAgo

        )


        db.collection("feedList").document(postedAgo).set(feedMap).addOnCompleteListener {

        }.addOnFailureListener {

        }

    }


    fun recuperaFeed(): Flow<MutableList<Feed>> {
        val listaFeed: MutableList<Feed> = mutableListOf()

        db.collection("feedList").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (documento in querySnapshot.result) {
                    val post = documento.toObject(Feed::class.java)
                    listaFeed.add(post)

                    _todosFeed.value = listaFeed
                }
            }
        }
        return todosFeed
    }
}