package com.tiago.instagramclone

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.ui.theme.InstagramCloneTheme
import com.tiago.instagramclone.ui.view.HomeScreen
import com.tiago.instagramclone.ui.view.FeedPublication
import com.tiago.instagramclone.ui.view.StoryPublication

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                //HomeScreen()


                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "homeScreen"){
                    composable(
                        route = "homeScreen"
                    ){
                        HomeScreen(navController)
                    }

                    composable(
                        route = "feedPublication"
                    ){
                        FeedPublication(navController)
                    }

                    composable(
                        route = "storyPublication"
                    ){
                        StoryPublication(navController)
                    }


                }






            }
        }
    }
}

