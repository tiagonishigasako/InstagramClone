package com.tiago.instagramclone.ui.view.toolsBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.tiago.instagramclone.ui.theme.NextColor
import com.tiago.instagramclone.ui.theme.spacingLarge
import com.tiago.instagramclone.ui.theme.spacingMedium
import com.tiago.instagramclone.ui.theme.spacingSmall

@Composable
fun CreateAccToolBar(navController: NavController) {

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .height(56.dp)
            .fillMaxWidth(),

        ) {
        Box(modifier = Modifier) {
            Column {
                Divider(
                    color = MaterialTheme.colorScheme.onSurface,
                    thickness = 3.dp
                )

                Spacer(modifier = Modifier.padding(spacingMedium))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Don't have an account?",
                        modifier = Modifier.weight(0.5f),
                        textAlign = TextAlign.End
                    )

                    Spacer(modifier = Modifier.padding(spacingSmall))

                    Text(
                        text = "Sign Up",
                        modifier = Modifier
                            .weight(0.3f)
                            .clickable { },
                        color = NextColor,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.padding(spacingLarge))


            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CreateAccToolBarPreview() {
    CreateAccToolBar(rememberNavController())
}