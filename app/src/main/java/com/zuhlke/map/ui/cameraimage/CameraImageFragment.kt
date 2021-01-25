package com.zuhlke.map.ui.cameraimage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.zuhlke.map.databinding.FragmentCameraImageBinding
import com.zuhlke.map.di.Injectable
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [CameraImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CameraImageFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: CameraImageViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentCameraImageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCameraImageBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        AndroidSupportInjection.inject(this)
        (arguments?.get("cameradata") as CameraData).let {
            binding.cameradata = CameraData(it.imageUrl,it.imageTakenDate)
        }
    }

}