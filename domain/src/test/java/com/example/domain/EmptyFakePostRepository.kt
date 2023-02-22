package com.example.domain

import com.example.domain.entity.PostDetail
import com.example.domain.repository.PostRepository

class EmptyFakePostRepository : PostRepository {
    var getPostDetailIsCalled = false

    override suspend fun getPostDetail(postId: Long): PostDetail {
        return PostDetail(
            id = 0,
            image = "",
            title = "",
            body = ""
        ).also {
            getPostDetailIsCalled = true
        }
    }

}