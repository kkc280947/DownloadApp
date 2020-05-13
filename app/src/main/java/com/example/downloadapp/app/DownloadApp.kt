package com.example.downloadapp.app

import android.app.Application
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig

/**
* Custom Application class to initialize PRDownloader
* */
class DownloadApp : Application(){

    override fun onCreate() {
        super.onCreate()
        val config = PRDownloaderConfig.newBuilder()
            .setReadTimeout(30000)
            .setConnectTimeout(30000)
            .build()
        PRDownloader.initialize(applicationContext, config)
    }
}