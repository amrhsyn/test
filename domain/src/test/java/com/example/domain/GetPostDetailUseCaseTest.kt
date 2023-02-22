package com.example.domain

import com.example.domain.repository.PostRepository
import com.example.domain.use_case.GetPostDetailUseCase
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetPostDetailUseCaseTest {


    @Test
    fun checkResponseIdIsTrue() = runBlocking {
        val getPostDetailUseCase = GetPostDetailUseCase(postRepository = mockk(relaxed = true))

        val postId: Long = 20

        val postDetail = getPostDetailUseCase.invoke(postId)

        Assert.assertEquals(postId, postDetail.id)
    }

    @Test
    fun checkResponseImageIsNotEmpty() = runBlocking {
        val getPostDetailUseCase = GetPostDetailUseCase(postRepository = mockk(relaxed = true))

        val postId: Long = 20

        val postDetail = getPostDetailUseCase.invoke(postId)

        Assert.assertTrue(postDetail.image.isNotEmpty())
    }

    @Test
    fun checkResponseImageIsTrue() = runBlocking {

        val postId: Long = 20

        val postRepository: PostRepository = EmptyFakePostRepository()

        val getPostDetailUseCase = GetPostDetailUseCase(postRepository = postRepository)

        val postDetail = getPostDetailUseCase.invoke(postId)

        Assert.assertTrue(postDetail.image.isNotEmpty())

    }

    @Test
    fun checkPostRepositoryIsCalled() = runBlocking {

        val postId: Long = 20

        val postRepository = EmptyFakePostRepository()

        val getPostDetailUseCase = GetPostDetailUseCase(postRepository = postRepository)

        getPostDetailUseCase.invoke(postId)

        Assert.assertTrue(postRepository.getPostDetailIsCalled)

    }

    @Test
    fun checkPostDetailUseCaseReturnsValidData() = runBlocking {

        val postId: Long = 20

        val postRepository = FakeFilledPostRepository()

        val getPostDetailUseCase = GetPostDetailUseCase(postRepository = postRepository)

        val postDetail = getPostDetailUseCase.invoke(postId)

        Assert.assertEquals(postRepository.postDetail.id, postDetail.id)

    }
    @Test
    fun checkPostDetailUseCaseReturnsValidImage() = runBlocking {

        val postId: Long = 20

        val postRepository = FakeFilledPostRepository()

        val getPostDetailUseCase = GetPostDetailUseCase(postRepository = postRepository)

        val postDetail = getPostDetailUseCase.invoke(postId)

        Assert.assertEquals(postRepository.postDetail.image, postDetail.image)

    }
}

