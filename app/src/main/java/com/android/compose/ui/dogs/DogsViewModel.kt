package com.android.compose.ui.dogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.compose.data.remote.common.Resource
import com.android.compose.di.DispatcherModule.IoDispatcher
import com.android.compose.domain.usecase.FetchDogsUseCase
import com.android.compose.ui.dogs.DogsVmContract.Event
import com.android.compose.ui.dogs.DogsVmContract.State
import com.android.compose.ui.dogs.DogsVmContract.State.DefaultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel @Inject constructor(
    private val fetchDogsUseCase: FetchDogsUseCase,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel(), DogsVmContract.ViewModel {


    private val _uiState = MutableStateFlow<State>(DefaultState)
    override val uiState: StateFlow<State> = _uiState

    private val _uiEvent = MutableStateFlow<Event>(Event.DefaultEvent)
    override val uiEvent: StateFlow<Event> = _uiEvent

    init{
        invokeAction(DogsVmContract.Action.FetchDogs("terrier"))
    }

    override fun invokeAction(action: DogsVmContract.Action) {
        when (action) {
            is DogsVmContract.Action.FetchDogs -> fetchDogs(action.type)
        }
    }

    private fun fetchDogs(type: String) {
        viewModelScope.launch(dispatcher) {
            fetchDogsUseCase(type).collect {
                when (it.status) {
                    Resource.Status.SUCCESS -> _uiState.value =
                        State.DogsPage(it.data?.message ?: emptyList())
                    Resource.Status.ERROR -> _uiState.value = State.ErrorScreen
                    Resource.Status.LOADING -> _uiState.value = State.LoadingScreen
                }
            }
        }
    }

}