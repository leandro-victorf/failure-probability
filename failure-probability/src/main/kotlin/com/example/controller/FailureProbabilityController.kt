package com.example.controller

import com.example.model.FailureProbability
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import com.example.service.FailureProbabilityService as FailureProbabilityService1

@Controller("/failureProbability")
class FailureProbabilityController(@Inject private val failureProbabilityService: FailureProbabilityService1){

    @Get
    fun getfailureProbability(structure:FailureProbability
//        @QueryValue("wing-length") wingLength: String,
//        @QueryValue("wing-span") wingSpan: String,
//        @QueryValue("wing-thick") wingThick: String,
//        @QueryValue("wing-density") wingDensity: String,
//        @QueryValue("wingflow-limit") wingflowLimit: String

    ): String {
        return failureProbabilityService.calculateFailureProbability(structure)
    }
}