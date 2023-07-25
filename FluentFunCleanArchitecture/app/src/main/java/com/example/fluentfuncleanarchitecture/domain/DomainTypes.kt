/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.domain

import kotlinx.coroutines.flow.Flow

/**
 * A generic type for handling Repository.
 *
 * Reuse to all generic types.
 *
 * Lambda Function:
 *
 * () -> GenericResult
 *
 * @return GenericResult - Return the needed Result.
 */
typealias RepositoryType<GenericResult> = suspend () -> GenericResult

/**
 * A generic type for handling UseCase.
 *
 * Only use this when starting to call a useCase.
 *
 * Lambda Function:
 *
 * (GenericRepository) -> GenericResult
 *
 * @param GenericRepository a repository that stores and manage data result.
 *
 * @return GenericResult - Return the needed Result.
 */
typealias UseCaseType<GenericRepository, GenericResult> = suspend GenericRepository.() -> GenericResult

/**
 * A generic type for composing UseCase.
 *
 * Only use this when you want to compose the useCase.
 *
 * Lambda Function:
 *
 * (GenericRepository) -> GenericResult
 *
 * @param GenericRepository a repository that stores and manage data result.
 *
 * @return GenericResult - Return the needed Result.
 */
typealias ComposeUseCase<GenericRepository, GenericResult> = suspend GenericResult.(GenericRepository) -> GenericResult

typealias FlowUseCaseType<GenericRepository, GenericResult> = suspend GenericRepository.() -> Flow<GenericResult>

