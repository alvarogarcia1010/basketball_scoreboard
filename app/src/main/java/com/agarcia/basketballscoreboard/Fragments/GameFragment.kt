package com.agarcia.basketballscoreboard.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agarcia.basketballscoreboard.R
import kotlinx.android.synthetic.main.fragment_game_detail.*

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = GameFragmentArgs.fromBundle(it)
            tv_date.text = safeArgs.date
            tv_time.text = safeArgs.time
            tv_team_a.text = safeArgs.teamA
            tv_team_b.text = safeArgs.teamB
            tv_winner.text = "Ganador: ${safeArgs.winner}"
            tv_score_team_a.text = safeArgs.scoreA.toString()
            tv_score_team_b.text = safeArgs.scoreB.toString()
        }

    }

}