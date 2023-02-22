package com.example.domain.repository

import com.example.domain.entity.PostDetail

interface PostRepository {
    suspend fun getPostDetail(postId: Long): PostDetail
}