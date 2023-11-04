package com.tiago.instagramclone.ui.view

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tiago.instagramclone.R
import com.tiago.instagramclone.data.model.nickName
import com.tiago.instagramclone.data.repository.DataRepository
import com.tiago.instagramclone.ui.theme.NextColor
import com.tiago.instagramclone.ui.theme.spacingLarge
import com.tiago.instagramclone.ui.theme.spacingMedium
import com.tiago.instagramclone.ui.theme.spacingSmall
import com.tiago.instagramclone.ui.view.toolsBar.AddToolBar
import com.tiago.instagramclone.ui.view.toolsBar.PublicationToolBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StoryPublication(
    navController: NavController
) {
    var urlUserAvatar by remember { mutableStateOf("") }
    var userNickname by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val contex = LocalContext.current
    val dataRepository = DataRepository()

    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        containerColor = Color.Black,
        topBar = {
            Row(
                modifier = Modifier.padding(horizontal = spacingLarge)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_x),
                    modifier = Modifier
                        .size(34.dp)
                        .padding(end = spacingLarge)
                        .clickable(onClick = {
                            navController.popBackStack()
                        }),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground),

                    )
                Text(
                    text = "aaaa",
                    modifier = Modifier
                        .padding(top = spacingSmall)
                        .weight(1f),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )

                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                val current = LocalDateTime.now().format(formatter)

                Text(
                    text = "Salvar",
                    modifier = Modifier
                        .padding(spacingSmall)
                        .clickable(onClick = {
                            var message = false
                            scope.launch(Dispatchers.IO) {
                                if (userNickname.isEmpty() && urlUserAvatar.isEmpty()) {
                                    message = false
                                } else {
                                    dataRepository.salvarStory(
                                        userNickname = userNickname,
                                        userAvatar = urlUserAvatar,
                                        postedAgo = current.toString()
                                    )
                                    message = true

                                }
                            }
                            scope.launch(Dispatchers.Main) {
                                if (message) {
                                    Toast
                                        .makeText(
                                            contex,
                                            "Story salvo com sucesso.",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                    navController.popBackStack()
                                } else {
                                    Toast
                                        .makeText(
                                            contex,
                                            "Favor inserir User nickname e url profile image.",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            }


                        }),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = NextColor
                )
            }
        }
    )
    {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(top = 56.dp)
        ) {
            Column(
                modifier = Modifier
            ) {
                OutlinedTextField(
                    value = userNickname,
                    onValueChange =
                    { userNickname = it },
                    label = { Text(text = "User nick name") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    maxLines = 1,
                )
                OutlinedTextField(
                    value = urlUserAvatar,
                    onValueChange =
                    { urlUserAvatar = it },
                    label = { Text(text = "Url profile image") },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri)
                )


            }
        }
    }


}