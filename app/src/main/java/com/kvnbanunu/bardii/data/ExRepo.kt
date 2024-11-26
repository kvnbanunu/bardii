package com.kvnbanunu.bardii.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kvnbanunu.bardii.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.headers

class ExRepo(private val client: HttpClient) {
    suspend fun getEx(): Exercise {
        val response = client.get(Endpoints.MUSCLE.url + "biceps") {
            headers {
                append("X-Api-Key", BuildConfig.apiKey)
            }
        }
        val json = response.body<JsonObject>().toString()
        return Gson().fromJson(json, Exercise::class.java)
    }
}