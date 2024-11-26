package com.kvnbanunu.bardii.ui.state

import androidx.compose.runtime.mutableStateListOf
import com.kvnbanunu.bardii.data.ExRepo
import com.kvnbanunu.bardii.data.Exercise

class ExState(private val exRepo: ExRepo) {
    val exercises = mutableStateListOf<Exercise>()

    suspend fun getExercise() {
        exercises.also {
            it.clear()
            it.addAll(listOf(exRepo.getEx()))
        }
    }
}