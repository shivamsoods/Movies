package com.shivam.movies.repository

import com.shivam.movies.api.service.MovieService

class MainRepository(private val movieService: MovieService) {
    suspend fun getTopRatedMovies() = movieService.getTopRatedMovies()

    suspend fun getUpcomingMovies() = movieService.getUpcomingMovies()
}