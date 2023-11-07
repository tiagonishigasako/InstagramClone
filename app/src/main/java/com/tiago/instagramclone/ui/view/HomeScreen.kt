package com.tiago.instagramclone.ui.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firestore.admin.v1.Index
import com.tiago.instagramclone.R
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.data.model.Story
import com.tiago.instagramclone.data.repository.DataRepository
import com.tiago.instagramclone.ui.theme.spacingMedium
import com.tiago.instagramclone.ui.view.itens.FeedItem
import com.tiago.instagramclone.ui.view.itens.StoryItem
import com.tiago.instagramclone.ui.view.toolsBar.AddToolBar
import com.tiago.instagramclone.ui.view.toolsBar.InstagramToolBar
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier.background(MaterialTheme.colorScheme.background)
) {


    val context = LocalContext.current
    var updateListFeed = remember { mutableListOf<Feed>() }
    var updateListStory = remember { mutableListOf<Story>() }

    var isCliked by mutableStateOf(false)







    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),


        containerColor = Color.Black,

        bottomBar = {
            Divider(
                color = MaterialTheme.colorScheme.onSurface,
                thickness = 0.2.dp
            )
            AddToolBar(navController = navController)
        }


    ) {


        if (updateListFeed.isEmpty()) {
            updateListFeed = updateFeed()
            updateListStory = updateStory()
            isCliked = false
        } else if (isCliked) {
            updateListFeed = updateFeed()
            updateListStory = updateStory()
            isCliked = false
        }
        val isRefreshing by remember {
            mutableStateOf(false)
        }
        val state =
            rememberPullRefreshState(
                refreshing = isRefreshing,
                onRefresh = { isCliked = true }
            )





        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)

                .fillMaxSize()
        ) {


            Box(modifier = Modifier) {
                LazyColumn(

                    modifier = Modifier
                        .pullRefresh(state)
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    item { InstagramToolBar() }

                    item {
                        StoryList(
                            updateListStory = updateListStory,
                            navController = navController,
                            context = context
                        )
                    }



                    item {
                        Divider(
                            color = MaterialTheme.colorScheme.onSurface,
                            thickness = 0.2.dp
                        )
                    }

                    itemsIndexed(updateListFeed) { position, _ ->

                        FeedItem(
                            position = position,
                            feedList = updateListFeed.asReversed(),
                            context = context,
                            navController = navController
                        )

                    }
                    item {
                        Spacer(modifier = modifier.padding(top = 80.dp))
                    }

                }
                PullRefreshIndicator(
                    refreshing = isRefreshing,
                    state = state,
                    modifier = Modifier
                        .align(Alignment.TopCenter),
                    scale = false


                )
            }

        }
    }
}


@Composable
fun updateFeed(): MutableList<Feed> {
    val dataRepository = DataRepository()
    return dataRepository.recuperarFeed().collectAsState(mutableListOf()).value
}

@Composable
fun updateStory(): MutableList<Story> {
    val dataRepository = DataRepository()
    return dataRepository.recuperarStory().collectAsState(mutableListOf()).value
}


@Composable
fun StoryList(updateListStory: List<Story>, navController: NavController, context: Context) {
    LazyRow(modifier = Modifier.padding(top = spacingMedium)) {
        itemsIndexed(updateListStory) { position, _ ->
            Box {

                StoryItem(
                    position = position,
                    storyList = updateListStory.reversed(),
                    contex = context,
                    navController = navController
                )


            }
        }
    }
}




