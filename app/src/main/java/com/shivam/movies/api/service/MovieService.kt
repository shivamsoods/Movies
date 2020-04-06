package com.shivam.movies.api.service

import com.shivam.movies.api.model.TopRated
import com.shivam.movies.api.model.Upcoming
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

val API_KEY = "4f35f2a8fac6b8b90aebabfeaba1d65a"

interface MovieService {
    @GET("upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") api_key: String = API_KEY
    ): Response<Upcoming>

    @GET("top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api_key: String = API_KEY
    ): Response<TopRated>
}