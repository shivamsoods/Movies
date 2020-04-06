package com.shivam.movies.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.shivam.movies.R
import com.shivam.movies.adapter.TopListAdapter
import com.shivam.movies.adapter.UpcomingListAdapter
import com.shivam.movies.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.topRatedMovieLiveData!!.observe(this, Observer {
            rvTopRated.adapter = TopListAdapter( it)
            rvTopRated.setHasFixedSize(true)

        })

        mainViewModel.upcomingMovieLiveData?.observe(this, Observer {
            rvUpcoming.adapter = UpcomingListAdapter(this,it)
            rvUpcoming.setHasFixedSize(true)
        })

    }
}
