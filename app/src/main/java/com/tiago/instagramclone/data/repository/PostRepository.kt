package com.tiago.instagramclone.data.repository

import com.tiago.instagramclone.data.source.DataSource

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


}