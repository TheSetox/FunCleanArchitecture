/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.domain

import com.example.fluentfuncleanarchitecture.data.ObjectRepository
import kotlinx.coroutines.delay

/**
 * Use this when you want to quickly check the behavior.
 * Only use fake data on testing.
 */
private suspend fun main() {
    delay(2000)
    log("2 seconds")
    delay(2000)
    allResultWhenComposed(ObjectRepository)
}

/**
 * For debugging purposes. Make it false if you will not use it anymore.
 */
private const val debugMode = true

private val log = { result: Any -> if (debugMode) println("UseCase: $result") }

// UseCase that creates a fluent api.
val allResultWhenComposed: UseCaseType<Repository, Result> = {
    firstResult(this)
        .secondResult(this)
        .thirdResult(this)
}

// UseCase that calls other useCase
val sampleResult: UseCaseType<Repository, Result> = {
    getSampleResult()
    getResult()
    getSecondResult()
    getThirdResult()
}


private val firstResult: UseCaseType<Repository, Result> = {
    getResult()
        .also(log)
}

private val secondResult: ComposeUseCase<Repository, Result> = {
    it.getSecondResult()
        .also(log)
}

private val thirdResult: ComposeUseCase<Repository, Result> = {
    it.getThirdResult()
        .also(log)
}

val resultFlow: FlowUseCaseType<Repository, Result> = { getFlow }
