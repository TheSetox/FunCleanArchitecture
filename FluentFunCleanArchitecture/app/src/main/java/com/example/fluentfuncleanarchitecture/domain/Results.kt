/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.domain

sealed class Result
data class Error(val error: String) : Result()
data class Success(val entity: MainEntity) : Result()
