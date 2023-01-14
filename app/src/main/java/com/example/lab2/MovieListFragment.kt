package com.example.lab2

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.adapters.RecyclerViewAdapter
import com.example.lab2.databinding.FragmentMovieListBinding
import com.example.lab2.models.Movie


class MovieListFragment : Fragment(R.layout.fragment_movie_list),
    MovieDialog.AddListener {

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private val service = FakeApiService()
    private lateinit var movies: MutableList<Movie>
    private lateinit var adapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inf = inflater.inflate(R.layout.fragment_movie_list, container, false)
        _binding = FragmentMovieListBinding.bind(inf)

        movies = service.getAllMovies()
        val recycler = binding.recyclerView
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(inf.context )

        adapter = RecyclerViewAdapter(inf.context,movies){position ->
            onMovieClick(
                position
            )
        }

        binding.addMovie.setOnClickListener{
            val dialog = MovieDialog()
            dialog.setAddMovieDialogListener(this)
            dialog.show(childFragmentManager,"Add a Movie")
        }

        recycler.adapter = adapter

        return inf
    }
    private fun onMovieClick(position: Int){
        val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(movies[position])
        findNavController().navigate(action)
    }

    override fun addMovie(
        title: String,
        actors: String,
        direc: String,
        id: Int,
        desc: String
    ) {
        val actrs: MutableList<String> = actors.split(",") as MutableList<String>
        val movie = Movie(id.toLong(), title, desc, direc, actrs)
        service.addMovie(movie)

    }
}