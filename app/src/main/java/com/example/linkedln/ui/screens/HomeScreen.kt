package com.example.linkedln.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.CommentBank
import androidx.compose.material.icons.outlined.Recycling
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.linkedln.R
import com.example.linkedln.data.LinkedInPost
import com.example.linkedln.data.dummyPosts
import com.example.linkedln.ui.theme.LinkedlnTheme

@Composable
fun HomeScreen() {
    Column {
        PostListCard(postList = dummyPosts)

    }
}

@Composable
fun PostListCard(postList: List<LinkedInPost>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        item { Spacer(modifier = Modifier.height(1.dp)) }
        items(postList) { post ->
            PostCard(linkedInPost = post)
        }
    }

}

@Composable
fun PostCard(linkedInPost: LinkedInPost, modifier: Modifier = Modifier) {
    Card(
        modifier.background(Color.White),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = CardDefaults.shape
    ) {
        Column(modifier = Modifier.padding(bottom = 10.dp)) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = linkedInPost.author.profilePictureUrl),
                    contentDescription = linkedInPost.author.name,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(40.dp),

                    )
                Column(Modifier.weight(1f)) {
                    Text(
                        text = linkedInPost.author.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = linkedInPost.author.headline,
                        style = MaterialTheme.typography.labelSmall.copy(color = Color.Gray)
                    )
                }
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
                Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
            }
            Text(
                text = linkedInPost.content,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            if (linkedInPost.media?.url != null)
                Image(
                    painter = painterResource(id = linkedInPost.media.url),
                    contentDescription = linkedInPost.media.type.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.blue_like),
                        contentDescription = null,
                        tint = Color.Unspecified,

                        modifier = Modifier

                            .size(20.dp),
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "john doe and 20 others liked",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Text(text = "4 comments", style = MaterialTheme.typography.bodySmall)
            }
            Divider(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {

                ActionIcon(imageVector = Icons.Outlined.ThumbUp, title = "Like")
                ActionIcon(imageVector = Icons.Outlined.CommentBank, title = "Comment")
                ActionIcon(imageVector = Icons.Outlined.Recycling, title = "Repost")
                ActionIcon(imageVector = Icons.AutoMirrored.Outlined.Send, title = "Send")

            }
        }
    }

}

@Composable
fun ActionIcon(imageVector: ImageVector, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(imageVector = imageVector, contentDescription = null)
        Text(text = title, style = MaterialTheme.typography.titleMedium.copy())
    }
}

@Preview(showBackground = false, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    LinkedlnTheme {
        HomeScreen()
    }
}