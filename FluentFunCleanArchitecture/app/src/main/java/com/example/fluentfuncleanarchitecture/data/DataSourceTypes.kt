/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.data

/**
 * A generic type for Source.
 *
 * Then reuse it to different types of Source.
 *
 * Lambda Function:
 *
 * () -> GenericData
 *
 * @return GenericData - Return the needed data. Ex. String, Int, List, Object
 */
typealias Source<GenericData> = suspend () -> GenericData

/**
 * A generic type for handling Remote Source that will differentiate from other source.
 *
 * Lambda Function:
 *
 * () -> GenericData
 *
 * @return GenericData - Return the needed data. Ex. String, Int, List, Object
 */
typealias RemoteSource<GenericData> = Source<GenericData>

/**
 * A generic type for handling Local Source that will differentiate from other source.
 *
 * Lambda Function:
 *
 * () -> GenericData
 *
 * @return GenericData - Return the needed data. Ex. String, Int, List, Object
 */
typealias LocalSource<GenericData> = Source<GenericData>