package com.agarcia.basketballscoreboard.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.agarcia.basketballscoreboard.Adapters.GameAdapter
import com.agarcia.basketballscoreboard.R
import com.agarcia.basketballscoreboard.Room.Entities.Game
import com.agarcia.basketballscoreboard.ViewModels.GameViewModel
import kotlinx.android.synthetic.main.fragment_list_game.view.*

class GameListFragment : Fragment(){

    lateinit var gameViewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_game, container, false)

        init(view)

        return view
    }

    fun init(view: View){
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        var adapter = object : GameAdapter(view.context){
            override fun setClickListenerToGame(holder: ViewHolder, item: Game) {
                holder.itemView.setOnClickListener {
                    val nextAction = GameListFragmentDirections.nextAction(item.date, item.time, item.teamA, item.teamB, item.scoreA, item.scoreB,  item.winner)
                    Navigation.findNavController(it).navigate(nextAction)
                }
            }

        }

        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        val fab: View = view.findViewById(R.id.fab_one)

        fab.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.new_action)
        }


        gameViewModel.allGames.observe(this, Observer { games ->
            games?.let { adapter.changeDataSet(it) }
        })
    }




}
