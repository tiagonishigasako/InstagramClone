package com.tiago.instagramclone.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tiago.instagramclone.data.model.Feed



@Composable
fun FeedItem(feed:Feed) {


}

@Preview(showBackground = true)
@Composable
fun FeedItemPreview(){
    FeedItem(feed = Feed(
        userNickname = "tiagoNishigasako",
        localName = "Brasil",
        userAvatar = "",
        imageUrl = "",
        description = "",
        postedAgo = "Há 2 dias"
    ))
}