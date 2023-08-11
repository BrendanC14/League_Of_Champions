package com.example.leagueofchampions.data

import kotlinx.coroutines.flow.Flow

class OfflineCompetitionsRepository(private val competitionDao : CompetitionDao) : CompetitionRepository {
    override fun getAllStream(): Flow<List<Competition>> = competitionDao.getAll()
    override fun getStreamWithId(id: Int): Flow<Competition> = competitionDao.getWithId(id)
    override suspend fun insert(competition: Competition) = competitionDao.insert(competition)
    override suspend fun delete(competition: Competition) = competitionDao.delete(competition)
    override suspend fun update(competition: Competition) = competitionDao.update(competition)
}