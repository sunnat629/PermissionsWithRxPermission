package dev.sunnat629.permissionswithrxpermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbruyelle.rxpermissions2.RxPermissions
import timber.log.Timber

class MainActivity : AppCompatActivity(), RXPContract.View {

    private lateinit var rxPermissions: RxPermissions
    private lateinit var presenter: RXPContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxPermissions = RxPermissions(this)
        presenter = RXPPresenterImpl(this, rxPermissions)
        askForPermissions()
    }

    private fun askForPermissions() {
        presenter.askPermissions()
    }

    override fun onPermissionGranted(permission: String) {
        Timber.tag("TAG").d("$permission: is granted !")
    }

    override fun onPermissionDeniedWithoutAskNeverAgain(permission: String) {
        Timber.tag("TAG").d("$permission: Denied permission without ask never again.")
    }

    override fun onPermissionDeniedWithAskNeverAgain(permission: String) {
        Timber.tag("TAG").d("$permission: Denied permission with ask never again. Need to go to the settings.")
    }
}