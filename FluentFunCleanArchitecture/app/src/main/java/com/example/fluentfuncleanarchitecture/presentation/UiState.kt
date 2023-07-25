/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.presentation

import com.example.fluentfuncleanarchitecture.domain.MainEntity

sealed class MainState

data object EmptyState : MainState()

class ShowContentState(val entity: MainEntity) : MainState()