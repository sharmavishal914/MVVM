package com.vishal.kotlinmvvm.util

import android.content.Context
import android.net.NetworkInfo
import android.net.ConnectivityManager


/**
 * Created by Administrator on 2/5/2018.
 */
class NetworkConnectivity(var context: Context) {
    fun isNetworkConnected(): Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivity != null) {
            val info = connectivity.allNetworkInfo
            if (info != null)
                for (i in info.indices)
                    if (info[i].state == NetworkInfo.State.CONNECTED) {
                        return true
                    }

        }
        return false
    }
}