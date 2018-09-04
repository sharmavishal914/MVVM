package com.vishal.kotlinmvvm.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


fun isNetworkConnected(context: Context): Boolean {
    val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = connectivity.allNetworkInfo
    if (info != null)
        for (i in info.indices)
            if (info[i].state == NetworkInfo.State.CONNECTED) {
                return true
            }

    return false
}



