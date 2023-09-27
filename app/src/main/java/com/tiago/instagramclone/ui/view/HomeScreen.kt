package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tiago.instagramclone.data.Story


@Composable
fun HomeScreen() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        InstagramToolBar()

        StoryItem(
            story = Story(
                userNickname = "Tiago",
                userAvatar = "https://i.pinimg.com/474x/8d/da/39/8dda39d89cea777270772bb62782035c.jpg"
            )
        )

    }

}


@Preview(showBackground = true)
@Composable

fun HomeScreenPreview() {
    HomeScreen()
}