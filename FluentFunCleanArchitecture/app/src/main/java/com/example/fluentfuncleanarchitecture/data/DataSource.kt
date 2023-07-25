/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.data

//First Data Source
val getId: LocalSource<Int> = { 0 }

//Second Data Source
val getTitle: RemoteSource<String> = { "Hello World" }