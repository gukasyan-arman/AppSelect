package com.example.appselect.api

import com.example.appselect.models.ResponseApi
import com.example.appselect.utils.END_POINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(END_POINT)
    suspend fun getAllMovies(
        @Query("page") page: Int
    ): Response<ResponseApi>

}