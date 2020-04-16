package com.sunshinedevpro.bicitracker.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.SupportMapFragment
import com.sunshinedevpro.bicitracker.constant.RequestCodeConstants
import com.sunshinedevpro.bicitracker.viewmodel.MapViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MapsFragment : SupportMapFragment() {

    private val mapViewModel: MapViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            mapViewModel.currentLocation.collect {
                // TODO: show coordinates
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {

            RequestCodeConstants.FINE_LOCATION_PERMISSION_REQUEST_CODE -> {
                if (
                    grantResults.isNotEmpty()
                    && grantResults.first()
                    == PackageManager.PERMISSION_GRANTED
                ) {
//                    vm.onLocationPermissionAccepted()
                } else {
//                    vm.onLocationPermissionDenied()
                }

            }
        }
    }
}