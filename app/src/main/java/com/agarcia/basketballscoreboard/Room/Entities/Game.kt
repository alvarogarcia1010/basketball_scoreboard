package com.agarcia.basketballscoreboard.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class Game(

    @ColumnInfo(name = "teamA")
    var teamA:String,

    @ColumnInfo(name = "scoreA")
    var scoreA:Int = 0,

    @ColumnInfo(name = "teamB")
    var teamB:String,

    @ColumnInfo(name = "scoreB")
    var scoreB:Int = 0,

    @ColumnInfo(name = "date")
    var date:String,

    @ColumnInfo(name = "time")
    var time:String,

    @ColumnInfo(name = "winner")
    var winner:String,

    @ColumnInfo(name = "syncronized")
    var syncronized:Int = 0
){

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}