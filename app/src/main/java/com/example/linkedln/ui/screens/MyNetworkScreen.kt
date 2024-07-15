package com.example.linkedln.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowRightAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.linkedln.R
import com.example.linkedln.data.LinkedInUser
import com.example.linkedln.data.LinkedinUsersDataSource
import com.example.linkedln.ui.theme.LinkedlnTheme

@Composable
fun MyNetworkScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Text(
                text = "Manage my network",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowRightAlt,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(30.dp)
            )
        }

//        NetworkCard(user = LinkedinUsersDataSource.linkedInUsers[0])
        NetwordGridList(userList = LinkedinUsersDataSource.linkedInUsers)


    }
}

@Composable
fun NetwordGridList(userList: List<LinkedInUser>, modifier: Modifier = Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.background(Color.White)
    ) {
        items(userList) { user ->
            NetworkCard(user = user)

        }
    }
}

@Composable
fun NetworkCard(user: LinkedInUser) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.image1), contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    contentScale = ContentScale.Crop,
                )
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = user.profilePictureUrl),
                        contentDescription = null,
                        Modifier
                            .clip(CircleShape)
                            .size(100.dp)
                    )
                }

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W500)
                )

                Text(text = user.headline, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Based on your profile", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, color = Color(0xFF0a66c2)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Connect", style = MaterialTheme.typography.labelLarge)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyNetworkScreenPreview() {
    MyNetworkScreen()
}

//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun NetworkGridListPreview() {
//    NetwordGridList(userList = LinkedinUsersDataSource.linkedInUsers)
//}
//
//@Preview
//@Composable
//fun NetworkCardPreview() {
//    LinkedlnTheme {
//
//        NetworkCard(user = LinkedinUsersDataSource.linkedInUsers[0])
//    }
//}
