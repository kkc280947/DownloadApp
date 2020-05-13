package com.example.downloadapp.ui

import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.example.downloadapp.R
import com.example.downloadapp.common.getFileFormat
import com.example.downloadapp.data.DataHelper
import com.example.downloadapp.model.DownloadItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DownloadItemAdapter.OnDownloadActionPerform {

    private lateinit var downloadAdapter : DownloadItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        downloadAdapter = DownloadItemAdapter(this)
        recyclerDownloadList.adapter = downloadAdapter
        downloadAdapter.addDownloadableItems(DataHelper.getDownloadItemList())
    }

    override fun startDownload(downloadInfo: DownloadItem, position:Int) {
        val fileName = downloadInfo.fileName.replace("\\s".toRegex(), "")+ getFileFormat(downloadInfo.fileType)
        val downloadId = PRDownloader.download(downloadInfo.url,getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)?.absolutePath, fileName)
                .build()
                .setOnCancelListener {
                    downloadAdapter.onCancel("Cancel", position)
                }.setOnProgressListener {
                    val progressPercent: Long = it.currentBytes * 100 / it.totalBytes
                    downloadAdapter.updateProgress(progressPercent, position)
                }
                .start(object : OnDownloadListener {
                    override fun onDownloadComplete() {
                        downloadAdapter.onDownloaded(position)
                    }
                    override fun onError(error: com.downloader.Error?) {
                        downloadAdapter.onCancel(error.toString(), position)
                    }
                })
        downloadAdapter.updateDownloadId(downloadId, position)
    }

    override fun cancelDownload(downloadId: Int) {
        PRDownloader.cancel(downloadId)
    }
}
