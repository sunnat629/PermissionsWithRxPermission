package dev.sunnat629.permissionswithrxpermission

import android.Manifest
import com.tbruyelle.rxpermissions2.RxPermissions
import timber.log.Timber

class RXPPresenterImpl(
    private val view: RXPContract.View,
    private val rxPermissions: RxPermissions
) : RXPContract.Presenter {

    override fun askPermissions() {
        rxPermissions
            .requestEach(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE)
            .subscribe ({
                when {
                    it.granted -> {
                        view.onPermissionGranted(it.name)
                    }
                    it.shouldShowRequestPermissionRationale -> {
                        view.onPermissionDeniedWithoutAskNeverAgain(it.name)
                    }
                    else -> {
                        view.onPermissionDeniedWithAskNeverAgain(it.name)
                    }
                }
            }, {
                Timber.tag("TAG").e(it.message)
            }, {
                Timber.tag("TAG").i("Permission taken complete.")
            })
    }
}
