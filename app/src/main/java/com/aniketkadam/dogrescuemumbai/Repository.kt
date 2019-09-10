package com.aniketkadam.dogrescuemumbai

class Repository(private val locationProvider: LocationProvider) {

    fun isLocationGranted(): Boolean =
        locationProvider.isLocationGranted()

    fun getCurrentLocation() = locationProvider.getCurrentLocation()
}