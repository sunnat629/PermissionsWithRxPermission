package dev.sunnat629.permissionswithrxpermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbruyelle.rxpermissions2.RxPermissions

class MainActivity : AppCompatActivity() {

    private lateinit var rxPermissions: RxPermissions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rxPermissions = RxPermissions(this)

        askForPermissions()
    }

    private fun askForPermissions() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}