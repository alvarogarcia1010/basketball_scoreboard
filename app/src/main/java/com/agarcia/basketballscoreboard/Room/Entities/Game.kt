package com.agarcia.basketballscoreboard.Room.Entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class Game(

    @ColumnInfo(name = "teamA")
    var teamA: String,

    @ColumnInfo(name = "scoreA")
    var scoreA: Int = 0,

    @ColumnInfo(name = "teamB")
    var teamB: String,

    @ColumnInfo(name = "scoreB")
    var scoreB: Int = 0,

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "time")
    var time: String,

    @ColumnInfo(name = "winner")
    var winner: String,

    @ColumnInfo(name = "syncronized")
    var syncronized: Int = 0
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(teamA)
        writeInt(scoreA)
        writeString(teamB)
        writeInt(scoreB)
        writeString(date)
        writeString(time)
        writeString(winner)
        writeInt(syncronized)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Game> = object : Parcelable.Creator<Game> {
            override fun createFromParcel(source: Parcel): Game = Game(source)
            override fun newArray(size: Int): Array<Game?> = arrayOfNulls(size)
        }
    }
}