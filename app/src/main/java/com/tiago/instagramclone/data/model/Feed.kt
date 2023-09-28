package com.tiago.instagramclone.data.model

import android.provider.ContactsContract.CommonDataKinds.Nickname

class Feed(
    val userNickname: String,
    val localName: String,
    val userAvatar: String,
    val imageUrl: String,
    val description: String,
    val postedAgo: String
    )