package com.example.downloadapp.model

/**
 * Data class to preserve state of file items.
* */
data class DownloadItem (
    val url : String,
    val fileType : String,
    var downloadId : Int,
    val fileName : String,
    var progress : Long,
    var status : Int) {
    constructor(url: String, fileType: String, fileName: String) : this(url,
        fileType,
        0,
        fileName,
        0,
        0)
}