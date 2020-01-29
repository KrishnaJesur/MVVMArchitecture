package com.krishna.kotlinlist.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.krishna.kotlinlist.R


open class BaseActivity : AppCompatActivity(), BaseNavigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        BaseViewModel(this, this)

    }

    override fun onLogout() {
//        Preferences.clearPreference(this)
//        val intent = LoginActivity.getInstance(this)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
    }

    override fun onUpdateApp(mandatory: Boolean) {
//        if (mandatory) {
//            AppUpdateAlertDialog.createDialogForceUpdate(this, this)
//        } else {
//            AppUpdateAlertDialog.createDialog(this, this)
//        }
    }

    override fun onMaintenance() {

    }

    override fun onUnauthorised() {
//        LogoutAlertDialog.createUnauthorisedDialog(this, this)
    }


}