package com.example.leagueofchampions.data

import android.content.Context

interface AppContainer {
    val competitionRepository : CompetitionRepository
}

class AppDataContainer(private val context : Context) : AppContainer {
    override val competitionRepository: CompetitionRepository by lazy {
        OfflineCompetitionsRepository(DBHandler.getDatabase(context).competitionDao())
    }
}