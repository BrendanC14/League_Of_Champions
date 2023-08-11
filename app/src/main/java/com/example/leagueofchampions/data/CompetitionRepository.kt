package com.example.leagueofchampions.data

import kotlinx.coroutines.flow.Flow

interface CompetitionRepository {

    fun getAllStream() : Flow<List<Competition>>
    fun getStreamWithId(id : Int) : Flow<Competition>
    suspend fun insert(competition: Competition)
    suspend fun delete(competition: Competition)
    suspend fun update(competition: Competition)
}