package com.example.leagueofchampions.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leagueofchampions.data.Competition
import com.example.leagueofchampions.data.CompetitionRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(competitionRepository: CompetitionRepository) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
        competitionRepository.getAllStream().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class HomeUiState(val competitionList: List<Competition> = listOf())