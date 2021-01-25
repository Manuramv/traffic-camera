package com.zuhlke.map.data.model

sealed class TrafficImageResults {
    data class Success(val data: TrafficImageResponse?) : TrafficImageResults()
    data class Error(val error: Exception) : TrafficImageResults()
}