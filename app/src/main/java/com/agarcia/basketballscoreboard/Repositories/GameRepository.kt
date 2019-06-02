package com.agarcia.basketballscoreboard.Repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.agarcia.basketballscoreboard.Room.Dao.GameDao
import com.agarcia.basketballscoreboard.Room.Entities.Game

class GameRepository(private val gameDao: GameDao) {

    fun getAllGames(): LiveData<List<Game>> = gameDao.getAllGames()

    @WorkerThread
    suspend fun insert(game: Game) = gameDao.insert(game)

    @WorkerThread
    suspend fun updateSyncronizedState(idGame:Int) = gameDao.updateSyncronizedState(idGame)

}