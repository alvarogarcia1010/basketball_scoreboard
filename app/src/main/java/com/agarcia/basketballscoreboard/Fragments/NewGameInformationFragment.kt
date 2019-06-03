package com.agarcia.basketballscoreboard.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.agarcia.basketballscoreboard.R
import kotlinx.android.synthetic.main.fragment_new_game_information.*

class NewGameInformationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_game_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button_save.setOnClickListener { view ->

            val nextAction = NewGameInformationFragmentDirections.nextAction(
                edit_team_a.text.toString(),
                edit_team_b.text.toString(),
                edit_date.text.toString(),
                edit_time.text.toString()
            )
            Navigation.findNavController(view).navigate(nextAction)
        }
    }

}