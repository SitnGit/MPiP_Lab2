package com.example.lab2

import com.example.lab2.models.Movie

class FakeApiService {

    private val movies: MutableList<Movie>  = mutableListOf(
        Movie(1, "Movie1", "Desc1", "Dir1", mutableListOf("Actor1", "Actor2")),
        Movie(2, "Movie2", "Desc2", "Dir2", mutableListOf("Actor1", "Actor3")),
        Movie(3, "Movie3", "Desc3", "Dir3", mutableListOf("Actor2", "Actor3")),
    )

    fun getAllMovies(): MutableList<Movie> {
        return movies;
    }

    fun addMovie(movie: Movie) : MutableList<Movie> {
        movies.add(movie)
        return movies
    }

}