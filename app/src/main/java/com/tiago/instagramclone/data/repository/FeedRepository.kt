package com.tiago.instagramclone.data.repository

import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.source.DataSource
import kotlinx.coroutines.flow.Flow

class FeedRepository {

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




}