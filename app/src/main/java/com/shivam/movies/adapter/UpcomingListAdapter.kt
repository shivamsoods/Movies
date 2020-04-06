package com.shivam.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.shivam.movies.R
import com.shivam.movies.api.model.Upcoming
import kotlinx.android.synthetic.main.item_movie.view.*


class UpcomingListAdapter(val context: Context, private val upcoming: Upcoming) :
    RecyclerView.Adapter<UpcomingListAdapter.ExampleViewHolder>() {

    private val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_movie,
            parent, false
        )

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = upcoming.results[position]

        val moviePosterURL = POSTER_BASE_URL + currentItem.posterPath
        holder.imageView.load(moviePosterURL)
        holder.textView1.text = currentItem.title
        holder.textView2.text = currentItem.releaseDate
    }

    override fun getItemCount() = upcoming.results.size

    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.cv_movie_poster
        val textView1: TextView = itemView.cv_movie_title
        val textView2: TextView = itemView.cv_movie_release_date
    }


}
