package com.example.leagueofchampions

import android.app.Application
import com.example.leagueofchampions.data.AppContainer
import com.example.leagueofchampions.data.AppDataContainer

class LeagueOfChampionsApplication : Application() {
    lateinit var container : AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}