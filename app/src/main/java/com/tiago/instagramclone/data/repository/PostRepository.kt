package com.tiago.instagramclone.data.repository

import android.net.Uri
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.source.DataSource
import kotlinx.coroutines.flow.Flow

class PostRepository {

    private val dataSource = DataSource()
    fun salvarPost(
        userNickname: String,
        localName: String,
        userAvatar: String,
        imageUrl: String,
        description: String,
        postedAgo: String
    ){
        dataSource.salvarPost(userNickname, localName, userAvatar, imageUrl, description, postedAgo)
    }

    fun recuperarPost(): Flow<MutableList<Feed>>{
        return dataSource.recuperaPosts()
    }




}