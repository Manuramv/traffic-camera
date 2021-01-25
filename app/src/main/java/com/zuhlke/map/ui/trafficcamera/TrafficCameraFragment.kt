package com.zuhlke.map.ui.trafficcamera

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.zuhlke.map.R
import com.zuhlke.map.data.model.TrafficImageResults
import com.zuhlke.map.data.trafficmap.TrafficMap
import com.zuhlke.map.databinding.FragmentTrafficCameraBinding
import com.zuhlke.map.di.Injectable
import com.zuhlke.map.ui.cameraimage.CameraData
import com.zuhlke.map.ui.cameraimage.EventObserver
import com.zuhlke.map.utils.AlertUtils
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrafficCameraFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TrafficCameraFragment : Fragment(), Injectable, OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {
    val TAG = TrafficCameraFragment::class.java.canonicalName
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var mMap: GoogleMap? = null
    val viewModel: TrafficCameraViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentTrafficCameraBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrafficCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.mapView.onCreate(savedInstanceState);
        binding.mapView.getMapAsync(this)
        binding.mapView.onResume();
        AndroidSupportInjection.inject(this)
        initObservers()
    }

    fun initObservers(){
        viewModel.getTrafficImages().observe(viewLifecycleOwner,{
            when (it) {
                is TrafficImageResults.Success ->{
                    viewModel.parseTheMapData(it.data)
                }
                is TrafficImageResults.Error -> {
                    displayError(it.error.toString())
                }
            }
        })

        viewModel.trafficLiveData.observe(viewLifecycleOwner,{
            setTheMapMarkerandInfo(it)
        })

    }

    //Here we will get the call back once the map is ready
    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
    }


    //set the map marker and custom info windo
    private fun setTheMapMarkerandInfo(trafficMapList: List<TrafficMap>) {
        trafficMapList.forEach {
           val markerOptions =  MarkerOptions().position(LatLng(it.lat, it.longitude)).visible(true).anchor(0.5f, 0.5f)
            val marker = mMap?.addMarker(markerOptions)
            marker?.tag = it
            marker?.showInfoWindow()
            mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(it.lat, it.longitude),18f))
            mMap?.setOnMarkerClickListener(this)
        }
    }

    //map marker click
    override fun onMarkerClick(marker: Marker?): Boolean {
        navigateAndShowImage(marker?.tag as TrafficMap)
        return false
    }

    //once when user is cicking on the marker take them to the cameraimage
    fun navigateAndShowImage(taggedCameraData: TrafficMap) {
        val bundle = bundleOf("cameradata" to CameraData(taggedCameraData.imgUrl,taggedCameraData.timestamp) )
        findNavController().navigate(
            R.id.action_trafficFragment_to_cameraImageFragment,
             bundle
        )
    }

    //Display error snackbar and onclicking the retry call the API again
    private fun displayError(msg:String){
        AlertUtils.showSnackBar(binding.root,msg,"retry",object :View.OnClickListener{
            override fun onClick(v: View?) {
                initObservers()
            }
        })
    }
}