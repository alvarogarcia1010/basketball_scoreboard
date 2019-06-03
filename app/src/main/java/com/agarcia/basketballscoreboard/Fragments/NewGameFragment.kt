package com.agarcia.basketballscoreboard.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.agarcia.basketballscoreboard.ViewModels.GameViewModel
import kotlinx.android.synthetic.main.fragment_new_game.*
import com.agarcia.basketballscoreboard.R
import com.agarcia.basketballscoreboard.Room.Entities.Game
import com.agarcia.basketballscoreboard.ViewModels.ScoreViewModel


class NewGameFragment : Fragment() {

    lateinit var gameViewModel: GameViewModel
    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = NewGameFragmentArgs.fromBundle(it)
            tv_date.text = safeArgs.date
            tv_time.text = safeArgs.time
            tv_team_a.text = safeArgs.TeamA
            tv_team_b.text = safeArgs.TeamB
        }

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        button_save_game.setOnClickListener {
            var winner = ""
            if(tv_score_team_a.text.toString().toInt() > tv_score_team_b.text.toString().toInt()){
                winner = tv_team_a.text.toString()
            }else{
                winner = tv_team_b.text.toString()
            }

            val game = Game(
                tv_team_a.text.toString(),
                tv_score_team_a.text.toString().toInt(),
                tv_team_b.text.toString(),
                tv_score_team_b.text.toString().toInt(),
                tv_date.text.toString(),
                tv_time.text.toString(),
                winner,
                0)

            try {
                gameViewModel.insertGame(game)
                Navigation.findNavController(view).navigate(R.id.save_game)

            } catch (e: Exception){
                Log.d("CODIGO", e.message)
            }
        }

        bt_team_a_3_p.setOnClickListener{
            addThreeTeamA(it)
        }

        bt_team_a_2_p.setOnClickListener{
            addTwoTeamA(it)
        }

        bt_team_a_free_throw.setOnClickListener{
            addOneTeamA(it)
        }

        bt_team_b_3_p.setOnClickListener{
            addThreeTeamB(it)
        }

        bt_team_b_2_p.setOnClickListener{
            addTwoTeamB(it)
        }

        bt_team_b_free_throw.setOnClickListener{
            addOneTeamB(it)
        }

        bt_reset.setOnClickListener{
            resetScores(it)
        }

        scoreViewModel.scoreTeamA.observe(this, Observer { score ->
            score?.let { displayScore(tv_score_team_a,it) }
        })

        scoreViewModel.scoreTeamB.observe(this, Observer { score ->
            score?.let { displayScore(tv_score_team_b,it) }
        })
    }

    fun addOneTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = scoreViewModel.scoreTeamA.value?.plus(1)
    }

    fun addOneTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = scoreViewModel.scoreTeamB.value?.plus(1)

    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = scoreViewModel.scoreTeamA.value?.plus(2)
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = scoreViewModel.scoreTeamB.value?.plus(2)

    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA.value = scoreViewModel.scoreTeamA.value?.plus(3)
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB.value = scoreViewModel.scoreTeamB.value?.plus(3)

    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA.value = 0
        scoreViewModel.scoreTeamB.value = 0

    }

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }

}
