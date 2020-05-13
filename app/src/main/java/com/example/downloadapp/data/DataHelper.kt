package com.example.downloadapp.data

import com.example.downloadapp.model.DownloadItem

/**
* Helper class to generate list of downloadable item using url from firebase server.
* */
object DataHelper {

    const val DOWNLOADING = 1
    const val DOWNLOADED = 2
    const val STOP = 3

    const val IMAGE_TYPE = "image/jpg"
    const val VIDEO_TYPE = "video/mp4"
    const val PDF_TYPE = "application/pdf"

    fun getDownloadItemList(): MutableList<DownloadItem>{
        val itemDownloadList = mutableListOf<DownloadItem>()
        itemDownloadList.add(
            DownloadItem(
                "https://firebasestorage.googleapis.com/v0/b/downloadapp-5a856.appspot.com/o/Screenshot%20(10).png?alt=media&token=359e486d-ceec-46e0-8635-19050e57f381",
                IMAGE_TYPE, "Image 470KB"
            )
        )
        itemDownloadList.add(
            DownloadItem(
                "https://firebasestorage.googleapis.com/v0/b/downloadapp-5a856.appspot.com/o/2015-Ford-Mustang-Apollo-Edition-4K-UHD-Wallpaper.jpg?alt=media&token=829c78d0-67cc-4771-bbd1-dbd5d54a16e5",
                IMAGE_TYPE,
                "Car Image 10MB"
            )
        )
        itemDownloadList.add(
            DownloadItem(
                "https://firebasestorage.googleapis.com/v0/b/downloadapp-5a856.appspot.com/o/small.mp4?alt=media&token=254712df-67a9-47ae-afdd-96177e0f7847",
                VIDEO_TYPE, "Video 374KB"
            )
        )
        itemDownloadList.add(
            DownloadItem(
                "https://firebasestorage.googleapis.com/v0/b/downloadapp-5a856.appspot.com/o/Panasonic_HDC_TM_700_P_50i.mp4?alt=media&token=e5dcb080-38e2-45c3-8577-938e5aea81c0",
                VIDEO_TYPE,
                "Panasonic Video 33MB"
            )
        )
        itemDownloadList.add(
            DownloadItem(
                "https://firebasestorage.googleapis.com/v0/b/downloadapp-5a856.appspot.com/o/sample.pdf?alt=media&token=908a6ae7-8796-4e6d-a6f4-2159df3b0c5f",
                PDF_TYPE,
                "Sample PDF 2KB"
            )
        )
        itemDownloadList.add(
            DownloadItem(
                "https://firebasestorage.googleapis.com/v0/b/downloadapp-5a856.appspot.com/o/1008-Article%20Text-4742-1-10-20131007.pdf?alt=media&token=01fcb178-12b3-43a1-b419-0f698347a7f9",
                PDF_TYPE,
                "Article Text PDF 10MB"
            )
        )
        return itemDownloadList
    }
}