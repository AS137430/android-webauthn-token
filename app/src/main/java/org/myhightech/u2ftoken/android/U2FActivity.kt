package org.myhightech.u2ftoken.android

import android.os.Bundle
import org.myhightech.u2ftoken.R
import org.myhightech.u2ftoken.ble.profiles.U2FProfile


class U2FActivity : AbstractBleActivity() {

    private var mU2FPeripheral: U2FProfile? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        title = "U2F Token"
    }

    override fun setupBlePeripheralProvider() {
        mU2FPeripheral = U2FProfile(this)
        mU2FPeripheral!!.startAdvertising()
    }

    override fun onDestroy() {
        if (mU2FPeripheral != null) {
            mU2FPeripheral!!.stopAdvertising()
            mU2FPeripheral = null
        }
        super.onDestroy()
    }
}
