package com.tiago.instagramclone.data.source

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.model.Story
import com.tiago.instagramclone.data.model.UserAuth
import com.tiago.instagramclone.data.model.authenticated
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val db = FirebaseFirestore.getInstance()
    private val _todosFeed = MutableStateFlow<MutableList<Feed>>(mutableListOf())
    private val todosFeed: StateFlow<MutableList<Feed>> = _todosFeed
    private val _todosStory = MutableStateFlow<MutableList<Story>>(mutableListOf())
    private val todosStory: StateFlow<MutableList<Story>> = _todosStory
    private val auth = FirebaseAuth.getInstance()
    private var message = false
    private val _userInfo = MutableStateFlow<MutableList<UserAuth>>(mutableListOf())
    private val userInfo: StateFlow<MutableList<UserAuth>> = _userInfo

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
                for (document in querySnapshot.result) {
                    val post = document.toObject(Feed::class.java)
                    listaFeed.add(post)

                    _todosFeed.value = listaFeed
                }
            }
        }
        return todosFeed
    }

    fun salvarStory(
        userNickname: String, userAvatar: String, postedAgo: String
    ) {
        val storyMap = hashMapOf(
            "userNickname" to userNickname, "userAvatar" to userAvatar, "postedAgo" to postedAgo
        )

        db.collection("storyList").document(postedAgo).set(storyMap).addOnCompleteListener {

        }.addOnFailureListener {

        }

    }

    fun recuperarStory(): Flow<MutableList<Story>> {
        val listaStory: MutableList<Story> = mutableListOf()

        db.collection("storyList").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (document in querySnapshot.result) {
                    val story = document.toObject(Story::class.java)
                    listaStory.add(story)

                    _todosStory.value = listaStory
                }
            }
        }
        return todosStory

    }

    fun deletarFeed(postedAgo: String) {
        db.collection("feedList").document(postedAgo).delete().addOnCompleteListener {

        }.addOnCompleteListener {

        }
    }

    fun criarCadastro(email: String, senha: String) {
        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {

        }
    }

    fun authCadastro(email: String, senha: String, navController: NavController): Boolean {
        var _message = false

        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { autenticacao ->
            if (!autenticacao.isSuccessful) {
                _message = false
            } else {
                _message = true
                navController.navigate("homeScreen")
            }
        }
        message = _message
        return message
    }

    fun cadastroInfoUser(
        userEmail: String,
        userAvatar: String,
        userNickname: String,
        master: Boolean){
        val userMap = hashMapOf(
            "userEmail" to userEmail,
            "userAvatar" to userAvatar,
            "userNickname" to userNickname,
            "master" to master
        )

        db.collection("usuarios").document(userEmail).set(userMap).addOnCompleteListener {

        }.addOnFailureListener {

        }

    }

    fun loadInfoUser(userEmail: String): Flow<MutableList<UserAuth>>{
        val userInfoFire: MutableList<UserAuth> = mutableListOf()

        db.collection("usuarios")
            .whereArrayContains("userEmail", userEmail)
            .get()
            .addOnCompleteListener { querySnapshot  ->
                for(document  in querySnapshot.result ){
                    val user = document.toObject(UserAuth::class.java)
                    userInfoFire.add(user)

                    _userInfo.value = userInfoFire

                }

        }
        return userInfo
    }


}