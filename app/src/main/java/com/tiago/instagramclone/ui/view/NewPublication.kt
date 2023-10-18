package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.R
import com.tiago.instagramclone.ui.theme.NextColor
import com.tiago.instagramclone.ui.theme.spacingLarge


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
                PublicationTexUrl()

            }
        }

    }




}

@Preview(showBackground = true)
@Composable
fun NewPublicationPreview(){
    NewPublication(rememberNavController())
}