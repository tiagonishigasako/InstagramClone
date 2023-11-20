package com.tiago.instagramclone.data.repository

import androidx.navigation.NavController
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.model.Story
import com.tiago.instagramclone.data.model.UserAuth
import com.tiago.instagramclone.data.source.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class DataRepository {

    private val dataSource = DataSource()
    fun salvarFeed(
        userNickname: String,
        localName: String,
        userAvatar: String,
        imageUrl: String,
        description: String,
        postedAgo: String
    ) {
        dataSource.salvarFeed(userNickname, localName, userAvatar, imageUrl, description, postedAgo)
    }

    fun recuperarFeed(): Flow<MutableList<Feed>> {
        return dataSource.recuperaFeed()
    }

    fun salvarStory(
        userNickname: String,
        userAvatar: String,
        postedAgo: String
    ) {
        dataSource.salvarStory(userNickname, userAvatar, postedAgo)

    }

    fun recuperarStory(): Flow<MutableList<Story>> {
        return dataSource.recuperarStory()
    }

    fun deletarFeed(postedAgo: String) {
        dataSource.deletarFeed(postedAgo)
    }

    fun criarCadastro(email: String, senha: String) {
        dataSource.criarCadastro(email, senha)
    }

    fun authCadastro(email: String, senha: String, navController: NavController): Boolean {
        return dataSource.authCadastro(email, senha, navController)
    }

    fun cadastroInfoUser(
        userEmail: String,
        userAvatar: String,
        userNickname: String,
        master:Boolean
    ){
        dataSource.cadastroInfoUser(userEmail, userAvatar, userNickname, master)
    }

    fun loadInfoUser(userEmail: String): Flow<MutableList<UserAuth>>{
        return dataSource.loadInfoUser(userEmail = userEmail)
    }




}