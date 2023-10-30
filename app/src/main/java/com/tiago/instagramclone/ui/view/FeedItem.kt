package com.tiago.instagramclone.ui.view


import android.content.Context
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.tiago.instagramclone.R
import com.tiago.instagramclone.data.model.Feed
import com.tiago.instagramclone.ui.theme.Gray
import com.tiago.instagramclone.ui.theme.LikedColor
import com.tiago.instagramclone.ui.theme.spacingLarge
import com.tiago.instagramclone.ui.theme.spacingMedium
import com.tiago.instagramclone.ui.theme.spacingSmall


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FeedItem(
    position: Int,
    feedList: List<Feed>,
    context: Context) {

    val nicknameFeed = feedList[position].userNickname
    val avatarFeed = feedList[position].userAvatar
    val localFeed = feedList[position].localName
    val imageFeed = feedList[position].imageUrl
    val descriptionListFeed = feedList[position].description
    val agoFeed = feedList[position].postedAgo


    val likeIcon = R.drawable.ic_notification
    val likedIcon = R.drawable.ic_liked
    val messageIcon = R.drawable.ic_message2
    val commentIcon = R.drawable.ic_comment
    val bookmarkIcon = R.drawable.ic_bookmark


    val userAvatarContentDesc = stringResource(R.string.content_description_feed_avatar)
    val feedImageContentDesc = stringResource(R.string.content_description_feed_image)
    val likeContentDesc = stringResource(R.string.button_like_content_description)
    val messagemContentDesc = stringResource(R.string.button_message_content_description)
    val commentContentDesc = stringResource(R.string.button_comment_content_description)
    val bookmarkContentDesc = stringResource(R.string.button_bookmark_content_description)
    val messageToastText = stringResource(id = R.string.button_message_toast_text)
    val commentToastText = stringResource(id = R.string.button_comment_toast_text)
    val bookmarkToastText = stringResource(id = R.string.button_bookmark_toast_text)

    var isLiked by rememberSaveable {
        mutableStateOf(false)
    }

    val iconsColor = MaterialTheme.colorScheme.onBackground
    val likedColor = if (isLiked) LikedColor else iconsColor

    val context = LocalContext.current
    val duration = Toast.LENGTH_LONG




    Column(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
        Row(
            modifier = Modifier
                .padding(horizontal = spacingSmall)
                .padding(top = spacingLarge)
        ) {

            GlideImage(
                model = avatarFeed,
                contentDescription = userAvatarContentDesc,
                modifier = Modifier
                    .size(36.dp)
                    .fillMaxSize()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    text = nicknameFeed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingMedium),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = localFeed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = spacingMedium),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start
                )
            }


        }

        GlideImage(
            model = imageFeed,
            contentDescription = feedImageContentDesc,
            modifier = Modifier
                .padding(spacingLarge)
                .height(256.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(start = spacingMedium, top = spacingLarge)
        ) {

            FeedIcon(
                icon = if (isLiked) likedIcon else likeIcon,
                contentDescription = likeContentDesc,
                color = likedColor
            ) {
                isLiked = !isLiked
            }

            FeedIcon(
                icon = commentIcon, contentDescription = commentContentDesc, color = iconsColor
            ) {
               Toast.makeText(context, commentToastText, duration)
                   .show()

            }

            FeedIcon(
                icon = messageIcon, contentDescription = messagemContentDesc, color = iconsColor
            ) {
                Toast.makeText(context, messageToastText, duration)
                    .show()
            }


            Image(
                painter = painterResource(id = bookmarkIcon),
                contentDescription = bookmarkContentDesc,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = spacingLarge)
                    .weight(1f)
                    .wrapContentWidth(align = Alignment.End)
                    .clickable {
                        Toast.makeText(context, bookmarkToastText, duration)
                            .show()
                    },
                colorFilter = ColorFilter.tint(iconsColor)
            )


        }
        Row(
            modifier = Modifier
                .padding(horizontal = spacingSmall)
                .padding(top = spacingLarge)
        ) {

            val description = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(nicknameFeed)
                }
                append(" ")
                append(descriptionListFeed)
            }

            Text(
                text = description,
                modifier = Modifier.padding(horizontal = spacingMedium),
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                maxLines = 2
            )

        }

        Text(
            text = agoFeed,
            modifier = Modifier
                .padding(start = 12.dp)
                .padding(top = spacingSmall),
            maxLines = 2,
            color = Gray,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start

        )


    }

}

@Composable
fun FeedIcon(
    @DrawableRes icon: Int, contentDescription: String, color: Color, onclick: () -> Unit
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(40.dp)
            .padding(end = spacingLarge)
            .clickable { onclick() },
        colorFilter = ColorFilter.tint(color)
    )
}

//@Preview(showBackground = true)
//@Composable
//fun FeedItemPreview() {
//    FeedItem(
//        feed = feedList[0]
//    )
//}