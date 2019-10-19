package com.aniketkadam.dogrescuemumbai

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainVmFactory(private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainVm(repository) as T
    }

}