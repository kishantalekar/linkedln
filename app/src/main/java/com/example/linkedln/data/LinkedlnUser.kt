package com.example.linkedln.data

import com.example.linkedln.R

data class LinkedInUser(
    val id: String,
    val name: String,
    val profilePictureUrl: Int,
    val headline: String = "",
    val bannerImage: Int? = null
)


object LinkedinUsersDataSource {
    val linkedInUsers = listOf(
        LinkedInUser(
            id = "user_1",
            name = "Alice Jones",
            profilePictureUrl = R.drawable.avatar_0,
            headline = "Software developer"
        ),
        LinkedInUser(
            id = "user_2",
            name = "Bob Smith",
            profilePictureUrl = R.drawable.avatar_1,
            headline = "Influence"
        ),
        LinkedInUser(
            id = "user_3",
            name = "Charlie Davis",
            profilePictureUrl = R.drawable.avatar_2
        ),
        LinkedInUser(
            id = "user_4",
            name = "David Lee",
            profilePictureUrl = R.drawable.avatar_3
        ),
        LinkedInUser(
            id = "user_5",
            name = "Emily Johnson",
            profilePictureUrl = R.drawable.avatar_4
        ),
        LinkedInUser(
            id = "user_6",
            name = "Company Page",
            profilePictureUrl = R.drawable.avatar_5 // Assuming a company page
        ),
        LinkedInUser(
            id = "user_7",
            name = "Michael Garcia",
            profilePictureUrl = R.drawable.avatar_6
        )
    )
}
