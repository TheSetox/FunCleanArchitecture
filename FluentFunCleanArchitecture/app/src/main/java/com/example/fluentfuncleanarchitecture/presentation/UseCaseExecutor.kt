package com.example.fluentfuncleanarchitecture.presentation

import com.example.fluentfuncleanarchitecture.domain.FlowUseCaseType
import com.example.fluentfuncleanarchitecture.domain.Repository
import com.example.fluentfuncleanarchitecture.domain.Result
import com.example.fluentfuncleanarchitecture.domain.UseCaseType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository) {
    suspend infix fun fetches(useCase: UseCaseType<Repository, Result>): Result {
        return repository.useCase()
    }

    suspend infix fun prepares(useCase: FlowUseCaseType<Repository, Result>): Flow<Result> {
        return repository.useCase()
    }
}