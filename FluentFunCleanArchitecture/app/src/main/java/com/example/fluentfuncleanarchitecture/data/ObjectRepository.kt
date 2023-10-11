package com.example.fluentfuncleanarchitecture.data

import com.example.fluentfuncleanarchitecture.domain.MainEntity
import com.example.fluentfuncleanarchitecture.domain.Repository
import com.example.fluentfuncleanarchitecture.domain.RepositoryType
import com.example.fluentfuncleanarchitecture.domain.Result
import com.example.fluentfuncleanarchitecture.domain.Success
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object ObjectRepository: Repository {

    override val getResult: RepositoryType<Result> = {
        Success(MainEntity(getId(), getTitle()))
    }

    override val getSecondResult: RepositoryType<Result> = {
        Success(MainEntity(2, "Second Result"))
    }

    override val getThirdResult: RepositoryType<Result> = {
        Success(MainEntity(3, "Third Result"))
    }

    override val getFlow: Flow<Result> = flow {
        emit(Success(MainEntity(3, "Fourth Result")))
        delay(3000)
        emit(Success(MainEntity(3, "Fifth Result")))
        delay(4000)
        emit(Success(MainEntity(3, "Sixth Result")))
        delay(3000)
        emit(Success(MainEntity(3, "Seventh Result")))
        delay(3000)
        emit(Success(MainEntity(3, "End Result")))
    }

    override val getSampleResult: RepositoryType<Result> = {
        Success(MainEntity(3, "Reusable Result"))
    }

}