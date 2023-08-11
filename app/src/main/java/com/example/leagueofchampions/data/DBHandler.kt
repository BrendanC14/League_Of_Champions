package com.example.leagueofchampions.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Competition::class], version = 1, exportSchema = false)
abstract class DBHandler : RoomDatabase() {

    abstract fun competitionDao() : CompetitionDao

    companion object {
        @Volatile
        private var Instance : DBHandler? = null

        fun getDatabase(context : Context): DBHandler {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, DBHandler::class.java, "competition_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}