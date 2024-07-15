package com.example.linkedln.data

import com.example.linkedln.R

data class LinkedInPost(
    val id: String,
    val author: LinkedInUser,
    val content: String,
    val media: LinkedInMedia? = null,
    val engagement: LinkedInPostEngagement = LinkedInPostEngagement()
)


data class LinkedInMedia(
    val type: LinkedInMediaType, // Type of media (image, video, etc.)
    val url: Int
)

enum class LinkedInMediaType {
    IMAGE,
    VIDEO,
    ETC
}

data class LinkedInPostEngagement(
    val likesCount: Int = 0,
    val commentsCount: Int = 0,
    val sharesCount: Int = 0
)

val dummyPosts = listOf(
    LinkedInPost(
        id = "post_1",
        author = LinkedinUsersDataSource.linkedInUsers[0],
        content = "Just launched a new project I'm really excited about! Check it out: [link to project]",
        media = LinkedInMedia(
            type = LinkedInMediaType.IMAGE,
            url = R.drawable.image1
        ),
        engagement = LinkedInPostEngagement(likesCount = 123, commentsCount = 15, sharesCount = 7)
    ),
    LinkedInPost(
        id = "post_2",
        author = LinkedinUsersDataSource.linkedInUsers[1],
        content = "Looking for feedback on my latest design. Let me know what you think in the comments!",
        media = LinkedInMedia(
            type = LinkedInMediaType.VIDEO, url = R.drawable.image1

        ),
        engagement = LinkedInPostEngagement(likesCount = 45, commentsCount = 8, sharesCount = 2)
    ),

    LinkedInPost(
        id = "post_3",
        author = LinkedinUsersDataSource.linkedInUsers[2],
        content = "Congratulations to the team on a successful product launch!",
        media = LinkedInMedia(
            type = LinkedInMediaType.ETC, url = R.drawable.image1

        ), // Assuming a document type (ETC)
        engagement = LinkedInPostEngagement(likesCount = 82, commentsCount = 3, sharesCount = 4)
    ),
    LinkedInPost(
        id = "post_4",
        author = LinkedinUsersDataSource.linkedInUsers[3],
        content = "Sharing some insights on the future of AI in marketing. #AI #Marketing",
        media = LinkedInMedia(
            type = LinkedInMediaType.IMAGE, url = R.drawable.image1

        ),
        engagement = LinkedInPostEngagement(likesCount = 217, commentsCount = 42, sharesCount = 11)
    ),
    LinkedInPost(
        id = "post_5",
        author = LinkedinUsersDataSource.linkedInUsers[4],

        media = LinkedInMedia(
            type = LinkedInMediaType.VIDEO, url = R.drawable.image1

        ),
        content = "Excited to announce our new partnership with [Company Name]! #Partnership #Growth",
        engagement = LinkedInPostEngagement(likesCount = 152, commentsCount = 10, sharesCount = 6)
    ),
    LinkedInPost(
        id = "post_6",
        author = LinkedinUsersDataSource.linkedInUsers[5],
        content = "We're hiring! Check out our open positions and join our team. #Careers",
        media = LinkedInMedia(
            type = LinkedInMediaType.VIDEO, url = R.drawable.image1

        ),
        engagement = LinkedInPostEngagement(likesCount = 38, commentsCount = 5, sharesCount = 1)
    ),
    LinkedInPost(
        id = "post_7",
        author = LinkedinUsersDataSource.linkedInUsers[6],
        content = "Just finished reading a great book on leadership. Highly recommend it!",
        engagement = LinkedInPostEngagement(likesCount = 47, commentsCount = 2, sharesCount = 0)
    )
)
