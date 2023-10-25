package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.ktx.Firebase
import com.tiago.instagramclone.data.repository.PostRepository


@Composable
fun NewPublication(
    navController: NavController
){



    Box(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()){


        LazyColumn{
            item {
                PublicationToolBar(navController)

            }
            item {
                PublicationText()

            }
        }

    }





}

@Preview(showBackground = true)
@Composable
fun NewPublicationPreview(){
    NewPublication(rememberNavController())
}