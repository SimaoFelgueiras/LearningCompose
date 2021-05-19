package com.android.compose.ui.dogs

import androidx.lifecycle.ViewModel
import com.android.compose.domain.usecase.FetchDogsUseCase
import dagger.hilt.android.scopes.ViewModelScoped

class DogsViewModel @ViewModelScoped constructor(
        fetchDogsUseCase: FetchDogsUseCase) : ViewModel() {

}