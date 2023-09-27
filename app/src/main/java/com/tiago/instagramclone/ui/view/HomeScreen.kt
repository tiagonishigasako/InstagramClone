package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun HomeScreen() {


    Column (modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)){

        InstagramToolBar()

    }

}


@Preview(showBackground = true)
@Composable

fun HomeScreenPreview(){
    HomeScreen()
}