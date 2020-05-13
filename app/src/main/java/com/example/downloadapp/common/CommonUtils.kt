package com.example.downloadapp.common

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import com.example.downloadapp.data.DataHelper


/**
 * This class is used to use common functions.
* */

fun getDownloadStatusText(status: Int): String{
    return when(status){
        DataHelper.DOWNLOADING -> "Downloading"
        DataHelper.DOWNLOADED -> "Downloaded"
        DataHelper.STOP -> "Stopped"
        else-> ""
    }
}

fun getFileFormat(fileType: String): String{
    return when(fileType ){
        DataHelper.IMAGE_TYPE -> ".jpg"
        DataHelper.VIDEO_TYPE -> ".mp4"
        DataHelper.PDF_TYPE -> ".pdf"
        else -> ""
    }
}


fun Context.checkConnection(): Boolean {
    val connMgr = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connMgr.activeNetworkInfo
    if (activeNetworkInfo != null) { // connected to the internet
        // connected to the mobile provider's data plan
        return if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
            // connected to wifi
            true
        } else activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE
    }
    return false
}