package com.kvnbanunu.bardii.data

enum class Endpoints(val url:String) {
    BASE_URL("https://api.api-ninjas.com/v1/exercises"),
    MUSCLE("${BASE_URL.url}?muscle=")
}