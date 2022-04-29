package com.example.service

import com.example.model.FailureProbability

interface FailureProbabilityService {
    fun calculateFailureProbability(structure: FailureProbability): String
}
