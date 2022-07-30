package com.example.appselect.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.appselect.api.ApiService
import com.example.appselect.models.ResponseItem

class MoviesPagingSource(
    private val apiService: ApiService)
    : PagingSource<Int, ResponseItem>() {

    override fun getRefreshKey(state: PagingState<Int, ResponseItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseItem> {
        return try {

            val currentPage = params.key ?: 1
            val response = apiService.getAllMovies(currentPage)
            val data = response.body()?.results ?: emptyList()
            val responseData = mutableListOf<ResponseItem>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if(currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}