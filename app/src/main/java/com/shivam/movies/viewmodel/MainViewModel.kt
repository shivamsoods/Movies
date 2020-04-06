package com.shivam.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.movies.api.model.TopRated
import com.shivam.movies.api.model.Upcoming
import com.shivam.movies.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _topRatedMovieLiveData = MutableLiveData<TopRated>()
    val topRatedMovieLiveData: LiveData<TopRated>?
        get() = _topRatedMovieLiveData


    private val _upcomingMovieLiveData = MutableLiveData<Upcoming>()
    val upcomingMovieLiveData: LiveData<Upcoming>?
        get() = _upcomingMovieLiveData


    init {
        getTopRatedMovies()
        getUpcomingMovies()

    }

    private fun getUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMovieLiveData.value = mainRepository.getUpcomingMovies().body()
        }

    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            _topRatedMovieLiveData.value = mainRepository.getTopRatedMovies().body()
        }
    }
}