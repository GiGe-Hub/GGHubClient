package com.sophimp.ghub.app.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

/**
 *
 * @author: sfx
 * @since: 2021/12/9
 */
class ViewModelFactory(owner: SavedStateRegistryOwner, defaultArgs: Bundle?) :
    AbstractSavedStateViewModelFactory(
        owner, defaultArgs
    ) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(MainViewModel::class.java) -> MainViewModel()
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}