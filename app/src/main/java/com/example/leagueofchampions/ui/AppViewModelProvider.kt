package com.example.leagueofchampions.ui

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.leagueofchampions.LeagueOfChampionsApplication
import com.example.leagueofchampions.ui.home.HomeViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for HomeViewModel
        initializer {
            HomeViewModel(leagueOfChampionsApplication().container.competitionRepository)
        }

    }
}

fun CreationExtras.leagueOfChampionsApplication(): LeagueOfChampionsApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as LeagueOfChampionsApplication)