package com.agarcia.basketballscoreboard.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.agarcia.basketballscoreboard.Room.Dao.GameDao
import com.agarcia.basketballscoreboard.Room.Entities.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Game::class), version = 1)
public abstract class ScoreboardDB : RoomDatabase()
{
    abstract fun gameDao(): GameDao

    companion object{
        @Volatile
        private var INSTANCE: ScoreboardDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope):ScoreboardDB{
            val tempInstante = INSTANCE

            if(tempInstante != null) return tempInstante

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context.applicationContext, ScoreboardDB::class.java, "Scoreboard_database")
                    .addCallback(WordDatabaseCallback(scope))
                    .build()

                INSTANCE = instance

                return instance
            }
        }

        private class WordDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.gameDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(gameDao: GameDao) {

            if(gameDao.getGamesList().isEmpty()){
                var game = Game("Team A", 10, "Team B", 20, "1/06/2019", "12:45pm", "Team B",0)
                gameDao.insert(game)

                game = Game("Team C", 25, "Team D", 12, "02/06/2019", "3:45pm", "Team C",0)
                gameDao.insert(game)
            }

        }
    }
}
