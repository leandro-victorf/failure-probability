package com.example.model

import jakarta.inject.Singleton

@Singleton
data class FailureProbability(
        val wingLength: String,
        val wingSpan: String,
        val wingThick: String,
        val wingDensity: String,
        val wingflowLimit: String
)
