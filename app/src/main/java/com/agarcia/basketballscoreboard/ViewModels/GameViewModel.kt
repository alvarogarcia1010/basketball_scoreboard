package com.agarcia.basketballscoreboard.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.agarcia.basketballscoreboard.Repositories.GameRepository
import com.agarcia.basketballscoreboard.Room.Entities.Game
import com.agarcia.basketballscoreboard.Room.ScoreboardDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(app: Application): AndroidViewModel(app) {

    private val gameRepository: GameRepository
    val allGames: LiveData<List<Game>>

    init {
        val gameDao = ScoreboardDB.getDatabase(app, viewModelScope).gameDao()
        gameRepository = GameRepository(gameDao)
        allGames = gameRepository.getAllGames()
    }

    fun insertGame(game: Game) = viewModelScope.launch(Dispatchers.IO){
        gameRepository.insert(game)
    }

    fun updateSyncronizedState(id: Int) = viewModelScope.launch(Dispatchers.IO){
        gameRepository.updateSyncronizedState(id)
    }

}