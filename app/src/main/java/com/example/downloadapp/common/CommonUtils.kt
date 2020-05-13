package com.example.downloadapp.common

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