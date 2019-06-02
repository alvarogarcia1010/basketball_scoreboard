package com.agarcia.basketballscoreboard.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agarcia.basketballscoreboard.R
import com.agarcia.basketballscoreboard.Room.Entities.Game
import kotlinx.android.synthetic.main.game_item.view.*


abstract  class GameAdapter internal constructor(context: Context): RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    private val inflater = LayoutInflater.from(context)
    private var items = emptyList<Game>()

    abstract fun setClickListenerToGame(holder: ViewHolder, item: Game)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.game_item,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(items[position])
        setClickListenerToGame(holder,items[position])
    }


    internal fun changeDataSet(newDataSet: List<Game>) {
        this.items = newDataSet
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item: Game) = with(itemView){
            tv_result.text = "${item.teamA} ${item.scoreA} - ${item.scoreB} ${item.teamB}"
            tv_date.text = item.date
        }
    }

}