package com.sunshinedevpro.bicitracker.ui

import android.content.pm.PackageManager
import com.google.android.gms.maps.SupportMapFragment
import com.sunshinedevpro.bicitracker.constant.RequestCodeConstants

class MapsFragment : SupportMapFragment() {

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