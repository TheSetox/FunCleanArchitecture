/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.domain

import kotlinx.coroutines.flow.Flow

interface Repository {

    val getResult: RepositoryType<Result>

    val getSecondResult: RepositoryType<Result>

    val getThirdResult: RepositoryType<Result>

    val getFlow: Flow<Result>

    val getSampleResult: RepositoryType<Result>

}