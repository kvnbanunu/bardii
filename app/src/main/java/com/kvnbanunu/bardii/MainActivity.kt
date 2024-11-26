package com.kvnbanunu.bardii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kvnbanunu.bardii.ui.state.ExState
import com.kvnbanunu.bardii.ui.theme.BardiiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiKey = BuildConfig.apiKey
        val exRepo = (application as Bardii).exRepo

        setContent {
            val exState = ExState(exRepo)

            LaunchedEffect(exState) {
                exState.getExercise()
            }

            LazyColumn {
                items (exState.exercises.size) {
                    Text(exState.exercises[it].name, fontSize = 30.sp)
                }
            }
        }
    }
}

