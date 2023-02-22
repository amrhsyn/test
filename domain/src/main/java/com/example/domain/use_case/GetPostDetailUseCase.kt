package com.example.domain.use_case

import com.example.domain.repository.PostRepository

// test
// compiler
// logical
class GetPostDetailUseCase(private val postRepository: PostRepository) {

    suspend operator fun invoke(postId: Long): Response {
        val postDetail = postRepository.getPostDetail(postId)

        return Response(
            id = postId,
            image = postDetail.image,
            title = postDetail.title,
            body = postDetail.body
        )
    }

    data class Response(
        val id: Long,
        val image: String,
        val title: String,
        val body: String,
    )

}

