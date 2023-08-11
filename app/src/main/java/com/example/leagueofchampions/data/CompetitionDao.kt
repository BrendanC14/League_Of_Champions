package com.example.leagueofchampions.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionDao {
    @Query("SELECT * from competition ORDER BY name ASC")
    fun getAll() : Flow<List<Competition>>

    @Query("SELECT * from competition WHERE id = :id")
    fun getWithId(id : Int) : Flow<Competition>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Competition)

    @Update
    suspend fun update(item: Competition)

    @Delete
    suspend fun delete(item: Competition)
}