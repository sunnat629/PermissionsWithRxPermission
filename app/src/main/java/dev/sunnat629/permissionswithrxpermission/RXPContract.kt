package dev.sunnat629.permissionswithrxpermission

interface RXPContract {

    interface Presenter{

        fun askPermissions()
    }

    interface View {
        fun onPermissionGranted(permission: String)
        fun onPermissionDeniedWithoutAskNeverAgain(permission: String)
        fun onPermissionDeniedWithAskNeverAgain(permission: String)
    }
}