package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.core.app.Person.fromBundle
import androidx.navigation.fragment.findNavController
import com.example.lab2.databinding.FragmentMovieDetailsBinding
import com.example.lab2.databinding.FragmentMovieListBinding
import com.example.lab2.models.Movie

class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inf = inflater.inflate(R.layout.fragment_movie_details, container, false)
        _binding = FragmentMovieDetailsBinding.bind(inf)
        val id = binding.Id
        val title = binding.Title
        val dir = binding.Director
        val desc = binding.Desc
        val movie: Movie = MovieDetailsFragmentArgs.fromBundle(requireArguments()).movie

        title.text = movie.title
        id.text = "Id: ${movie.id}"
        dir.text = "Director: ${movie.dir}"
        desc.text = "Description: ${movie.desc}"

        val listView = binding.Actors
        listView.adapter = ArrayAdapter(inf.context, android.R.layout.simple_list_item_1, movie.actors!!)

        return inf
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}