package com.agarcia.basketballscoreboard.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.agarcia.basketballscoreboard.Room.Entities.Game
import com.agarcia.basketballscoreboard.Utilities.Constants

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: Game)

    @Query("SELECT * FROM ${Constants.GameTableName} ORDER BY id ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Query("SELECT * FROM ${Constants.GameTableName} ORDER BY id ASC")
    fun getGamesList(): List<Game>

    @Query("DELETE from ${Constants.GameTableName}")
    fun deleteAllGames()

    @Query("UPDATE ${Constants.GameTableName} SET syncronized = 1 WHERE id = :id")
    suspend fun updateSyncronizedState(id:Int)
}