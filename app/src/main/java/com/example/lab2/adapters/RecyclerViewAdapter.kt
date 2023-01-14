package com.example.lab2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.models.Movie

class RecyclerViewAdapter(val context: Context, private val movies: MutableList<Movie>, private val onMovieClick: (position: Int) -> Unit):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val onMovieClick: (position: Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val id: TextView = view.findViewById(R.id.idText)
        val title: TextView = view.findViewById(R.id.titleText)
        val director: TextView = view.findViewById(R.id.directorText)

        init {
            view.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onMovieClick(position)
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false)
        return ViewHolder(view) {position ->
            onMovieClick(
                position
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.id.text = "id: ${currentMovie.id.toString()}"
        holder.title.text = "title: ${currentMovie.title}"
        holder.director.text = "director: ${currentMovie.dir}"
    }

}