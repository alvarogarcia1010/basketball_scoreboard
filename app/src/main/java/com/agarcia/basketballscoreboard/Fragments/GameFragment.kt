package com.agarcia.basketballscoreboard.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agarcia.basketballscoreboard.R

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        arguments?.let {
            val safeArgs = BookFragmentArgs.fromBundle(it)
            name.text = safeArgs.name
            editorial.text = safeArgs.editorial
            favorite.text = safeArgs.favorite.toString()
        }
        */

    }


}