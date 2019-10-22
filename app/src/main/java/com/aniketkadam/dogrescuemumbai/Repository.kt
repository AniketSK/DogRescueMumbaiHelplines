package com.aniketkadam.dogrescuemumbai

import com.aniketkadam.dogrescuemumbai.data.AnimalHelpLine

class Repository(private val locationProvider: LocationProvider) {

    fun isLocationGranted(): Boolean =
        locationProvider.isLocationGranted()

    fun getCurrentLocation() = locationProvider.getCurrentLocation()

    fun getKnownLocations() = listOf<AnimalHelpLine>()

}