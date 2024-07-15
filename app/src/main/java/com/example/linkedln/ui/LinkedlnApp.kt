package com.example.linkedln.ui

import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.linkedln.R
import com.example.linkedln.ui.screens.HomeScreen
import com.example.linkedln.ui.screens.MyNetworkScreen
import com.example.linkedln.ui.screens.NotificationScreen
import com.example.linkedln.ui.screens.PostScreen


data class TabBarItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null
)


@Composable
fun LinkedlnApp() {
    val navController = rememberNavController()

    val home = TabBarItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Filled.Home
    )
    var network = TabBarItem(
        title = "Network",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Filled.Person
    )
    val post = TabBarItem(
        title = "Post",
        selectedIcon = Icons.Filled.Add,
        unselectedIcon = Icons.Filled.Add
    )
    val notification = TabBarItem(
        title = "Notification",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Filled.Notifications,
        badgeAmount = 3
    )
    val job = TabBarItem(
        title = "Job",
        selectedIcon = Icons.Filled.Mail,
        unselectedIcon = Icons.Filled.Mail
    )
    val tabList = listOf(home, network, post, notification, job)
    Scaffold(topBar = { LinkedlnTopAppBar() }, bottomBar = {
        TabView(tabList = tabList, navController = navController)
    }) {

        NavHost(
            navController = navController,
            startDestination = home.title,
            modifier = Modifier
                .padding(it)
                .background(Color.LightGray.copy(0.8f)).fillMaxSize(),

            ) {
            composable(
                home.title,

                exitTransition = {
                    ExitTransition.None
                },
            ) {
                HomeScreen()
            }
            composable(
                network.title,

                ) {
                MyNetworkScreen()
            }

            composable(
                post.title,

                ) {
                PostScreen()
            }
            composable(
                notification.title,

                ) {
                NotificationScreen()
            }
            composable(
                job.title,

                ) {
                NotificationScreen()
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkedlnTopAppBar() {

    CenterAlignedTopAppBar(

        title = {
            OutlinedTextField(
                value = "",
                placeholder = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
//                modifier = Modifier.background(LightBlue.copy(alpha = 0.6f)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(50.dp)


            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.avatar_8),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )

        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_message_24),
                contentDescription = null,
//                tint = Color.Gray.copy(alpha = 10f)
                Modifier.padding(10.dp)
            )
        },

        modifier = Modifier
            .padding(bottom = 5.dp)


    )
}

@Composable
fun TabView(tabList: List<TabBarItem>, navController: NavController) {
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(containerColor = Color.White, contentColor = Color.White) {
        tabList.forEachIndexed { index, tabItem ->
            val isSelected = selectedIndex == index
            NavigationBarItem(

                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    navController.navigate(tabItem.title)
                },
                icon = {
                    TabBarIconView(
                        tabItem.selectedIcon,
                        tabItem.unselectedIcon,
                        isSelected,
                        tabItem.title,
                        badgeAmount = tabItem.badgeAmount
                    )
                },

                colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White),
                label = { Text(text = tabItem.title, style = MaterialTheme.typography.labelSmall) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabBarIconView(
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    isSelected: Boolean,
    title: String,
    badgeAmount: Int? = null
) {
    BadgedBox(
        badge = { if (badgeAmount != null) Badge { Text(text = badgeAmount.toString()) } },
        modifier = Modifier
    ) {
        Icon(
            imageVector = if (isSelected) selectedIcon else unselectedIcon,
            contentDescription = title,
            tint = if (!isSelected) Color.Gray else Color.Black,
            modifier = Modifier.size(30.dp)

        )

    }
}

@Preview
@Composable
fun LinkedlnAppPreview() {
    LinkedlnApp()
}