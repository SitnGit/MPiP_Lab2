package com.example.lab2

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import java.util.*
import kotlin.random.Random.Default.nextInt

class MovieDialog: AppCompatDialogFragment() {


    interface AddListener {
        fun addMovie(title: String, actors: String, director: String, id: Int, description: String)
    }
    private lateinit var listener: AddListener;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.add_movie, null)
        val title: EditText? = view?.findViewById(R.id.addTitle)
        val actors: EditText? = view?.findViewById(R.id.addActors)
        val dir: EditText? = view?.findViewById(R.id.addDir)
        val desc: EditText? = view?.findViewById(R.id.addDesc)

        val index = nextInt(4,200)

        builder.setView(view)
            .setTitle("Add Movie")
            .setPositiveButton("Add Movie"){ _,_ ->
                val Title: String = title?.text.toString()
                val Actors: String = actors?.text.toString()
                val Dir: String = dir?.text.toString()
                val Desc: String = desc?.text.toString()

                listener.addMovie(Title, Actors, Dir, index, Desc)
            }
            .setNegativeButton("Exit") { _, _ ->}

        return builder.create()
    }

    fun setAddMovieDialogListener(listener: AddListener) {
        this.listener = listener
    }

}