package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PublicationTexUrl(){
    var urlUserAvatar by remember{ mutableStateOf("") }
    var userNickName by remember{ mutableStateOf("") }
    var urlImageUrl by remember{ mutableStateOf("") }
    var localName by remember{ mutableStateOf("") }
    var descripitionPost by remember { mutableStateOf("") }
    var postedAgo by remember { mutableStateOf("") }




    Column{
        OutlinedTextField(
            value = urlUserAvatar,
            onValueChange =
            { urlUserAvatar = it },
            label = { Text(text = "Url profile image") },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1
        )


        OutlinedTextField(
            value = urlImageUrl,
            onValueChange =
            { urlImageUrl = it },
            label = { Text(text = "Url publication image") },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1
        )

        OutlinedTextField(
            value = userNickName,
            onValueChange =
            { userNickName = it },
            label = { Text(text = "User nick name") },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1
        )

        OutlinedTextField(
            value = localName,
            onValueChange =
            { localName = it },
            label = { Text(text = "Local name") },
            modifier = Modifier
                .fillMaxWidth()
            ,
            maxLines = 1
        )

        OutlinedTextField(
            value = descripitionPost,
            onValueChange =
            { descripitionPost = it },
            label = { Text(text = "Description post") },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 3
        )

        OutlinedTextField(
            value = postedAgo,
            onValueChange =
            { postedAgo = it },
            label = { Text(text = "posted ago") },
            modifier = Modifier
                .fillMaxWidth(),
            maxLines = 1
        )
    }









}




@Preview(showBackground = true)
@Composable
fun PublicationTexUrlPreview(){
    PublicationTexUrl()
}