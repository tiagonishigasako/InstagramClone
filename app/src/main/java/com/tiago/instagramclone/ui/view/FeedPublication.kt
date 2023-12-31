package com.tiago.instagramclone.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.tiago.instagramclone.ui.view.itens.PublicationItens
import com.tiago.instagramclone.ui.view.toolsBar.PublicationToolBar


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FeedPublication(
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
                PublicationItens()

            }
        }

    }





}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NewPublicationPreview(){
    FeedPublication(rememberNavController())
}