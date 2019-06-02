package com.agarcia.basketballscoreboard.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.agarcia.basketballscoreboard.R
import com.agarcia.basketballscoreboard.ViewModels.GameViewModel
import kotlinx.android.synthetic.main.fragment_new_game.*
import java.lang.Exception


class NewGameFragment : Fragment() {

    lateinit var gameViewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        save_game.setOnClickListener {
            /*
            val book = Book(txtName.text.toString(), txtEditorial.text.toString(), 0)

            try {
                viewModel.insertBook(book)
                //viewModel.insertBookAuthor(bookAuthor)
                Log.d("CODIGO", "Creado con exito")
                txtName.setText("")
                txtEditorial.setText("")
                Toast.makeText(view.context, "Book created!!", Toast.LENGTH_LONG).show()
            } catch (e: Exception){
                Log.d("CODIGO", e.message)
            }
            */
            Toast.makeText(view.context, "Book created!!", Toast.LENGTH_LONG).show()
        }
    }

}
