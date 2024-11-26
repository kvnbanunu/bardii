package com.kvnbanunu.bardii

import android.app.Application
import com.kvnbanunu.bardii.data.ExRepo
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class Bardii: Application() {
    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }

    val exRepo by lazy {
        ExRepo(client)
    }
}