package com.shivam.movies.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shivam.movies.R
import com.shivam.movies.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

private val mainViewModel by viewModel<MainViewModel>()
}
