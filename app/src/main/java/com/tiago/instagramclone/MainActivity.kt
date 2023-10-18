package com.tiago.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.ui.theme.InstagramCloneTheme
import com.tiago.instagramclone.ui.view.HomeScreen
import com.tiago.instagramclone.ui.view.NewPublication

class MainActivity : ComponentActivity() {
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
                        route = "newPublication"
                    ){
                        NewPublication(navController)
                    }
                }






            }
        }
    }
}

