/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fluentfuncleanarchitecture.domain.Error
import com.example.fluentfuncleanarchitecture.domain.Result
import com.example.fluentfuncleanarchitecture.domain.Success
import com.example.fluentfuncleanarchitecture.domain.allResultWhenComposed
import com.example.fluentfuncleanarchitecture.domain.resultFlow
import com.example.fluentfuncleanarchitecture.domain.sampleResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(myUseCase: UseCase) : ViewModel() {

    private val _flow: MutableStateFlow<MainState> = MutableStateFlow(EmptyState)
    val flow: StateFlow<MainState> = _flow.asStateFlow()

    val loadResult = {
        viewModelScope.launch {
            _flow.update {
                updateStateWhen(myUseCase fetches allResultWhenComposed)
                updateStateWhen(myUseCase fetches sampleResult)
            }
        }
    }

    val loadFlowResult = {
        viewModelScope.launch {
            (myUseCase prepares resultFlow).collect { result ->
                _flow.update { updateStateWhen(result) }
            }
        }
    }

    private val updateStateWhen = { result: Result ->
        when (result) {
            is Error -> EmptyState
            is Success -> ShowContentState(result.entity)
        }
    }

}