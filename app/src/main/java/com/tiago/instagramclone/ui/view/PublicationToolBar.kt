package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.R
import com.tiago.instagramclone.data.repository.PostRepository
import com.tiago.instagramclone.ui.theme.NextColor
import com.tiago.instagramclone.ui.theme.spacingLarge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PublicationToolBar(navController: NavController){
    val newPubliText =  "Nova Publicação"
    val next = "Avançar"

    val scope = rememberCoroutineScope()
    val contex = LocalContext.current
    val postRepository = PostRepository()




    Box (modifier = Modifier.background(MaterialTheme.colorScheme.background)){
        Row(
            modifier = Modifier
                .padding(horizontal = spacingLarge)
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically,

        ){

            Image(
                painterResource(id = R.drawable.ic_x),
                modifier = Modifier
                    .size(34.dp)
                    .padding(end = spacingLarge)
                    .clickable(onClick = {
                        navController.navigate("homeScreen")
                    }),
                contentDescription = "",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),

            )



            Text(
                text = newPubliText,
                modifier = Modifier
                    .padding(end = spacingLarge)
                    .weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            Text(
                text  = next,
                style = MaterialTheme.typography.bodyLarge,
                color = NextColor,
                modifier = Modifier
                    .clickable (
                        onClick = {
                            scope.launch (Dispatchers.IO){


                            }
                        }
                    )

            )


        }
    }


}

@Preview(showBackground = true)
@Composable
fun PublicationToolBarPreview(){
    PublicationToolBar(rememberNavController())
}