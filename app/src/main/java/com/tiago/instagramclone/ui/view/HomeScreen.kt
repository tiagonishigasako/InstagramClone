package com.tiago.instagramclone.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.model.Story
import com.tiago.instagramclone.data.repository.PostRepository
import com.tiago.instagramclone.data.repository.stories
import com.tiago.instagramclone.ui.theme.spacingMedium


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun HomeScreen(
    navController: NavController
) {


    val context = LocalContext.current
    var updateList = remember { mutableListOf<Feed>() }
    var isCliked by mutableStateOf(false)






    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),


        containerColor = Color.Black,

        bottomBar = { AddToolBar(navController = navController) }


    ) {

        if (updateList.isEmpty()) {
            updateList = funUpdate()
            isCliked = false
        } else if (isCliked) {
            updateList = funUpdate()
            isCliked = false
        }





        Box(modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onLongPress = { isCliked = true })
            }
        ) {
            Column(modifier = Modifier.fillMaxSize()) {


                LazyColumn {
                    item { InstagramToolBar() }

                    item { }

                    item { StoryList(stories = stories) }

                    item {
                        Divider(
                            color = MaterialTheme.colorScheme.onSurface,
                            thickness = 0.2.dp
                        )
                    }

                    itemsIndexed(updateList) { position, _ ->
                        FeedItem(position = position, listaPosts = updateList, context = context)

                    }
                    item { Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 55.dp) }
                }
            }
        }

    }
}


@Composable
fun funUpdate(): MutableList<Feed> {
    val postRepository = PostRepository()
    return postRepository.recuperarPost().collectAsState(mutableListOf()).value
}


@Composable
fun StoryList(stories: List<Story>) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(stories) { _, item ->
            StoryItem(story = item)
        }
    }

}



