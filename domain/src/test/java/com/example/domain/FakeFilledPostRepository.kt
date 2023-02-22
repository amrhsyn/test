package com.example.domain

import com.example.domain.entity.PostDetail
import com.example.domain.repository.PostRepository

class FakeFilledPostRepository : PostRepository {
    var getPostDetailIsCalled = false
    val postDetail = PostDetail(
        id = 20,
        image = "https://google.com/image.png",
        title = "A post title",
        body = "A post body"
    )

    override suspend fun getPostDetail(postId: Long): PostDetail {

        return postDetail.also {
            getPostDetailIsCalled = true
        }
    }

}