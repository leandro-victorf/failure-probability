package com.example.service

import com.example.model.FailureProbability
import kotlin.math.pow

class DefaultFailureProbability(): FailureProbabilityService {
    override fun calculateFailureProbability(structure: FailureProbability): String {
        val wingThick = structure.wingThick.toDouble()
        val wingLength = structure.wingLength.toDouble()
        val wingSpan = structure.wingSpan.toDouble()
        val wingDensity = structure.wingDensity.toDouble()
        val wingflowLimit = structure.wingflowLimit.toDouble()
        val volume = wingThick * wingLength * wingSpan
        val fsSafetyFree = 1.0
        val administrativeTension = calculeteAdministrativeTension(wingflowLimit, fsSafetyFree)
        val weight =  calculeteWeight(volume, wingDensity)
        val resultMoment = weight * wingLength
        val inertiaMoment = calculeteInertiaMoment(wingLength, wingThick)
        val peformaceFunction = administrativeTension - (resultMoment - wingThick)/inertiaMoment

        return peformaceFunction.toString()

    }

    private fun calculeteAdministrativeTension(wingflowLimit: Double, fs: Double): Double{
        return wingflowLimit/fs
    }

    private fun calculeteWeight(volume: Double, wingDensity:Double): Double{
        return wingDensity * volume * 9.8
    }

    private fun calculeteInertiaMoment(wingLength: Double, wingThick: Double): Double{
        return  (wingLength * wingThick.pow(3.0))/12
    }

}