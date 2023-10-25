package com.tiago.instagramclone.data.source

import android.net.Uri
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.tiago.instagramclone.data.model.Feed
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val db = FirebaseFirestore.getInstance()
    private val _todosPosts = MutableStateFlow<MutableList<Feed>>(mutableListOf())
    private val todosPosts: StateFlow<MutableList<Feed>> = _todosPosts



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


    fun recuperaPosts(): Flow<MutableList<Feed>>{
        val listaPost: MutableList<Feed> = mutableListOf()

        db.collection("posts").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful){
                for (documento in querySnapshot.result) {
                    val post = documento.toObject(Feed::class.java)
                    listaPost.add(post)

                    _todosPosts.value = listaPost
                }
            }
        }
        return todosPosts
    }
}