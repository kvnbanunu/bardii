package com.kvnbanunu.bardii.data

import com.google.gson.annotations.SerializedName

data class Exercise(
    val name:String,
    val type:String,
    val muscle:String,
    val equipment:String,
    val difficulty:String,
    val instructions:String
)