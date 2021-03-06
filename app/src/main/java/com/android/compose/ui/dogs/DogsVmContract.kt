package com.android.compose.ui.dogs

import kotlinx.coroutines.flow.StateFlow

interface DogsVmContract {
    interface ViewModel {
        val uiState: StateFlow<State>
        val uiEvent: StateFlow<Event>

        fun invokeAction(action: Action)
    }

    sealed class Action {
        class FetchDogs(val type: String) : Action()
    }

    sealed class State {
        data class DogsPage(val dogsList: List<String>) : State()
        object LoadingScreen : State()
        object ErrorScreen : State()
        object DefaultState : State()
    }

    sealed class Event {
        object DefaultEvent : Event()
    }
}