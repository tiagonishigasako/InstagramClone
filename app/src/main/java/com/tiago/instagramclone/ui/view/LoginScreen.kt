package com.tiago.instagramclone.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.R
import com.tiago.instagramclone.data.model.autenticado
import com.tiago.instagramclone.data.repository.DataRepository
import com.tiago.instagramclone.ui.theme.NextColor
import com.tiago.instagramclone.ui.theme.spacingLarge
import com.tiago.instagramclone.ui.theme.spacingMedium
import com.tiago.instagramclone.ui.theme.spacingXLarge
import com.tiago.instagramclone.ui.view.toolsBar.CreateAccToolBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController) {

    val instagramLabel = stringResource(id = R.string.instagram)
    val loginText = stringResource(R.string.phone_number_username_or_email_address)
    val passwordText = stringResource(R.string.password)

    var userLogin by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    val dataRepository = DataRepository()



    var showPassword by remember {
        mutableStateOf(false)
    }



    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),


        containerColor = Color.Black,

        bottomBar = {
            CreateAccToolBar(navController)


        }

    ) {

        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(spacingLarge)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(bottom = 90.dp))
                Text(
                    text = instagramLabel,
                    modifier = Modifier,
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 45.sp,
                )

                OutlinedTextField(
                    value = userLogin,
                    onValueChange =
                    { userLogin = it },
                    label = { Text(text = loginText) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = MaterialTheme.typography.bodyLarge,
                    singleLine = true,
                    maxLines = 1,

                    )

                Spacer(modifier = Modifier.padding(5.dp))

                OutlinedTextField(
                    value = userPassword,
                    onValueChange =
                    { userPassword = it },
                    label = { Text(text = passwordText) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    singleLine = true,
                    maxLines = 1,
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        if (showPassword) {
                            IconButton(onClick = { showPassword = false }) {
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        } else {
                            IconButton(onClick = { showPassword = true }) {
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )

                Text(
                    text = "Forgotten password?",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacingLarge)
                        .clickable { },
                    textAlign = TextAlign.End,
                    color = NextColor,
                    style = MaterialTheme.typography.bodyLarge
                )

                Button(
                    onClick = {
                        if (userLogin.isNotEmpty() && userPassword.isNotEmpty()) {
                            dataRepository.authCadastro(email = userLogin, senha = userPassword)
                            if (autenticado) {
                                navController.navigate("homeScreen")
                            } else {

                            }


                        } else {

                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),

                    colors = ButtonDefaults.buttonColors(containerColor = NextColor),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Log In")
                }

                Row {
                    Divider(
                        modifier = Modifier
                            .padding(top = spacingLarge)
                            .weight(0.4f),
                        color = MaterialTheme.colorScheme.onSurface,
                        thickness = 3.dp
                    )

                    Text(
                        text = "Or",
                        modifier = Modifier
                            .padding(
                                start = spacingXLarge,
                                end = spacingXLarge,
                                top = spacingMedium
                            ),
                        style = MaterialTheme.typography.bodyLarge

                    )

                    Divider(
                        modifier = Modifier
                            .padding(top = spacingLarge)
                            .weight(0.4f),
                        color = MaterialTheme.colorScheme.onSurface,
                        thickness = 3.dp
                    )

                }
                Spacer(modifier = Modifier.padding(spacingLarge))

                Row {


                    Icon(
                        painter = painterResource(id = R.drawable.ic_facebook),
                        contentDescription = "",
                        modifier = Modifier
                            .size(15.dp),
                        tint = NextColor
                    )

                    Text(
                        text = "Login in with Facebook",
                        modifier = Modifier
                            .padding(start = spacingMedium)
                            .clickable { },
                        color = NextColor
                    )

                }


            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}