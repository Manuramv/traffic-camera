package com.zuhlke.map.ui.trafficcamera

import android.util.Log
import androidx.lifecycle.*
import com.zuhlke.map.data.model.TrafficImageResponse
import com.zuhlke.map.data.model.TrafficImageResults
import com.zuhlke.map.data.repository.CameraRepository
import com.zuhlke.map.data.trafficmap.TrafficMap
import com.zuhlke.map.ui.cameraimage.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrafficCameraViewModel  @Inject constructor(private val repository: CameraRepository): ViewModel(){
    var trafficLiveData = MutableLiveData<List<TrafficMap>>()

    fun getTrafficImages()=
        liveData {
            val repos = repository.getTrafficImages().asLiveData()
            emitSource(repos )
        }

    fun parseTheMapData(it: TrafficImageResponse?) {
        var trafficMapList = listOf<TrafficMap>()
        it?.items?.forEach {
            it.cameras.forEach {
                Log.i("tag","traffic item::"+it.location.latitude)
                val trafficMapItem = TrafficMap(
                    it.location.latitude,
                    it.location.longitude,
                    it.image,
                    it.timestamp
                )
                trafficMapList = trafficMapList.plus(trafficMapItem)
            }
        }
        trafficLiveData.value = trafficMapList
    }

    override fun onCleared() {
        super.onCleared()
    }


}
