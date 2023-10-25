package com.tiago.instagramclone.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiago.instagramclone.R
import com.tiago.instagramclone.ui.theme.spacingLarge
import com.tiago.instagramclone.ui.theme.spacingMedium
import com.tiago.instagramclone.ui.theme.spacingSmall


@Composable
fun InstagramToolBar() {

    val instagramLabel = stringResource(id = R.string.instagram)
    val notificationContentDesc = stringResource(R.string.content_description_notification_icon)
    val messageContentDesc = stringResource(R.string.content_description_message_icon)

    val iconColor = MaterialTheme.colorScheme.onBackground

    Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
            modifier = Modifier
                .padding(horizontal = spacingLarge)
                .height(56.dp),
            verticalAlignment = CenterVertically
        ) {

            Text(
                text = instagramLabel,
                modifier = Modifier.weight(1f).padding(top = spacingSmall),
                style = MaterialTheme.typography.headlineLarge
            )

            Image(
                painter = painterResource(id = R.drawable.ic_notification),
                modifier = Modifier
                    .size(34.dp)
                    .padding(end = spacingMedium),
                contentDescription = notificationContentDesc,
                colorFilter = ColorFilter.tint(iconColor)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_message),
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = spacingMedium),
                contentDescription = messageContentDesc,
                colorFilter = ColorFilter.tint(iconColor)
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun InstagramToolBarPreview() {
    InstagramToolBar()
}