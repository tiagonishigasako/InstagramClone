package com.tiago.instagramclone.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tiago.instagramclone.R
import com.tiago.instagramclone.ui.theme.NextColor
import com.tiago.instagramclone.ui.theme.spacingLarge
import com.tiago.instagramclone.ui.theme.spacingSmall

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateAccScreen(navController: NavController){

    val instagramLabel = stringResource(id = R.string.instagram)

    var userEmail by remember { mutableStateOf("") }
    var userNickname by remember { mutableStateOf("")}
    var userAvatar by remember { mutableStateOf("") }




    Scaffold(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column( modifier = Modifier
                .padding(spacingLarge)
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Spacer(modifier = Modifier.padding(bottom = 90.dp))

                Text(text = instagramLabel,
                    modifier = Modifier,
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 45.sp,
                )

                Text(text = "Sing up to see photos and videos from your friends.",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp)

                Spacer(modifier = Modifier.padding(spacingSmall))

                OutlinedTextField(
                    value = userEmail,
                    onValueChange = {userEmail = it },
                    label = { Text(text = "Email address.")},
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingLarge, end = spacingLarge),
                    singleLine = true,
                    maxLines = 1
                    )

                OutlinedTextField(
                    value = userNickname,
                    onValueChange = {userNickname = it },
                    label = { Text(text = "Nickname.")},
                    textStyle = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingLarge, end = spacingLarge),
                    singleLine = true,
                    maxLines = 1
                )

                OutlinedTextField(
                    value = userAvatar,
                    onValueChange = {userAvatar = it },
                    label = { Text(text = "Avatar address (only URL).")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingLarge, end = spacingLarge),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    singleLine = true,
                    maxLines = 1
                )

                Spacer(modifier = Modifier.padding(bottom = spacingLarge))

                Button(onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingLarge, end = spacingLarge),
                    colors = ButtonDefaults.buttonColors(containerColor = NextColor),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Sing Up.")

                }


            }


        }

    }

}