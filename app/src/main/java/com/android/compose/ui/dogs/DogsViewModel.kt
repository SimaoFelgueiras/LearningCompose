package com.android.compose.ui.dogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.compose.di.AppModule
import com.android.compose.domain.usecase.FetchDogsUseCase
import com.android.compose.ui.dogs.DogsVmContract.Event
import com.android.compose.ui.dogs.DogsVmContract.State
import com.android.compose.ui.dogs.DogsVmContract.State.DefaultState
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DogsViewModel @ViewModelScoped constructor(
    private val fetchDogsUseCase: FetchDogsUseCase,
    @AppModule.IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel(), DogsVmContract.ViewModel {


    private val _uiState = MutableStateFlow<State>(DefaultState)
    override val uiState: StateFlow<State> = _uiState

    private val _uiEvent = MutableStateFlow<Event>(Event.DefaultEvent)
    override val uiEvent: StateFlow<Event> = _uiEvent

    override fun invokeAction(action: DogsVmContract.Action) {
        TODO("Not yet implemented")
    }

    private fun fetchDogs(type: String) {
        viewModelScope.launch(dispatcher) {
            fetchDogsUseCase(type).collect {

            }
        }
    }

}