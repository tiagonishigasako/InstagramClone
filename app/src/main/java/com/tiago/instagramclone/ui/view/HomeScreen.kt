package com.tiago.instagramclone.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.model.Story
import com.tiago.instagramclone.data.repository.feedList
import com.tiago.instagramclone.data.repository.stories
import com.tiago.instagramclone.ui.theme.spacingMedium


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController
) {


    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)



    ) {


        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {

            item {
                InstagramToolBar()
                //PublicationToolBar()
            }

            item {
                StoryList(stories = stories)
            }

            item {
                Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 0.2.dp)
            }

            feedList(feedList = feedList)


        }


        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 0.2.dp)
            AddToolBar(navController)
        }


    }


}

@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(stories) { _, item ->
            StoryItem(story = item)
        }
    }

}

fun LazyListScope.feedList(feedList: List<Feed>) {
    itemsIndexed(feedList) { _, item ->
        FeedItem(feed = item)
    }
}


@Preview(showBackground = true,)
@Composable

fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}