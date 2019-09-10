package com.aniketkadam.dogrescuemumbai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aniketkadam.dogrescuemumbai.data.AnimalHelpLine

class MainVm(private val locationProvider: LocationProvider) : ViewModel() {

    private val _viewState = MutableLiveData<ViewState>()

    val viewState: LiveData<ViewState>
        get() = _viewState

    private fun getClosestAnimalHelpline() {
        // Get a list of all animal helplines
        // Filter the list for the one closest to the current coordinate
        // Set that as the one that should be shown
        // TODO()
    }

    init {
        _viewState.value =
            if (locationProvider.isLocationGranted()) ViewState.LocatingInProgress else ViewState.RequestLocationPermission
    }

}

/**
 * The view can either be:
 * 1. Asking for the location info
 * 2. Showing all the helplines
 * 3. Showing the current closest helpline
 */
sealed class ViewState {
    object RequestLocationPermission : ViewState()
    object LocatingInProgress : ViewState()
    object SeeAllHelpLines : ViewState()
    data class Helpline(val closestLocationHelpLine: AnimalHelpLine)
}