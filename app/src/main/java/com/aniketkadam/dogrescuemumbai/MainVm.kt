package com.aniketkadam.dogrescuemumbai

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aniketkadam.dogrescuemumbai.data.AnimalHelpLine

class MainVm : ViewModel() {

    private val _viewState = MutableLiveData<ViewState>()

    val viewState: LiveData<ViewState>
        get() = _viewState

    fun getClosestAnimalHelpline() {
        // Get a list of all animal helplines
        // Filter the list for the one closest to the current coordinate
        // Set that as the one that should be shown
        // TODO()
    }
}

/**
 * The view can either be:
 * 1. Asking for the location info
 * 2. Showing all the helplines
 * 3. Showing the current closest helpline
 */
sealed class ViewState {
    object GrantLocationPermission : ViewState()
    object SeeAllHelpLines : ViewState()
    data class Helpline(val closestLocationHelpLine: AnimalHelpLine)
}