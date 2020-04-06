package com.shivam.movies.di

import com.shivam.movies.api.service.MovieService
import com.shivam.movies.repository.MainRepository
import com.shivam.movies.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainModule = module {
    factory { provideMoviesService(get()) }
    single { MainRepository(get()) }

    viewModel { MainViewModel(get()) }
}

private fun provideMoviesService(retrofit: Retrofit) =
    retrofit.create(MovieService::class.java)
