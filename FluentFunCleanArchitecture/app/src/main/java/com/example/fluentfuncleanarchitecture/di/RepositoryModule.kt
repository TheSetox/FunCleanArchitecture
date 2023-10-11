/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.di

import com.example.fluentfuncleanarchitecture.data.ObjectRepository
import com.example.fluentfuncleanarchitecture.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun bindDataRepository(): Repository = ObjectRepository
}