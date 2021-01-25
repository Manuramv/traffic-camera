package com.zuhlke.map.data.repository

import android.util.Log
import com.zuhlke.map.data.model.TrafficImageResults
import com.zuhlke.map.data.remote.ApiInterface

import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CameraRepository @Inject constructor(private val retrofitService: ApiInterface) {
    val TAG = CameraRepository::class.java.canonicalName
    private val movieDetailsResult = ConflatedBroadcastChannel<TrafficImageResults>()

     suspend fun getTrafficImages(): Flow<TrafficImageResults> {
        requestData()
        return movieDetailsResult.asFlow()
    }

    private suspend fun requestData() {
        try {
            val response = retrofitService.getTrafficImages()
            Log.d(TAG,"response::"+response)
            movieDetailsResult.offer(TrafficImageResults.Success(response))
        } catch (exception: IOException) {
            movieDetailsResult.offer(TrafficImageResults.Error(exception))
        } catch (exception: HttpException) {
            movieDetailsResult.offer(TrafficImageResults.Error(exception))
        }
    }

    fun callMe(){

    }
}