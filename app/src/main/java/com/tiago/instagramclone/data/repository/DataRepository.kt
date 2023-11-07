package com.tiago.instagramclone.data.repository

import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.model.Story
import com.tiago.instagramclone.data.source.DataSource
import kotlinx.coroutines.flow.Flow

class DataRepository {

    private val dataSource = DataSource()
    fun salvarFeed(
        userNickname: String,
        localName: String,
        userAvatar: String,
        imageUrl: String,
        description: String,
        postedAgo: String
    ){
        dataSource.salvarFeed(userNickname, localName, userAvatar, imageUrl, description, postedAgo)
    }

    fun recuperarFeed(): Flow<MutableList<Feed>>{
        return dataSource.recuperaFeed()
    }

    fun salvarStory(
        userNickname: String,
        userAvatar: String,
        postedAgo: String
        ){
        dataSource.salvarStory(userNickname, userAvatar, postedAgo)

    }

    fun recuperarStory(): Flow<MutableList<Story>>{
        return  dataSource.recuperarStory()
    }

    fun deletarFeed(postedAgo: String){
        dataSource.deletarFeed(postedAgo)
    }




}