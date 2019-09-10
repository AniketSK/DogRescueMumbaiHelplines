package com.aniketkadam.dogrescuemumbai

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aniketkadam.dogrescuemumbai.data.Location
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Rule
import org.junit.Test

class MainVmTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `when the app starts, location is requested if it is not already granted`() {
        val repository = mockk<Repository>(relaxed = true) {
            every { isLocationGranted() } returns false
        }

        val mainVm = MainVm(repository)

        assertThat(
            mainVm.viewState.getOrAwaitValue(),
            equalTo<ViewState>(ViewState.RequestLocationPermission)
        )
    }

    @Test
    fun `when the app starts, start getting the current location if the location permission is granted`() {
        val repository = mockk<Repository> {
            every { isLocationGranted() } returns true
            every { getCurrentLocation() } returns Location(1f, 2f)
        }

        val mainVm = MainVm(repository)

        assertThat(
            mainVm.viewState.getOrAwaitValue(),
            equalTo<ViewState>(ViewState.LocatingInProgress)
        )

        verify(exactly = 1) { repository.getCurrentLocation() }
    }


}