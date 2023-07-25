/*
 *  Created by FluentFunCleanArchitectureCaseStudy
 *  Copyright (c) 2023 . All rights reserved.
 */

package com.example.fluentfuncleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.fluentfuncleanarchitecture.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchStateCollector()
        viewModel.apply {
            loadResult()
            loadFlowResult()
        }
    }

    private val showLogs = { state: String -> Log.d("MainActivity", "onCreate: state is $state") }

    private val launchStateCollector = {
        lifecycleScope.launch {
            viewModel.flow.collect { state ->
                when (state) {
                    EmptyState -> showLogs(EmptyState::class.java.simpleName)
                    is ShowContentState -> showLogs(state.entity.toString())
                }
            }
        }
    }

}