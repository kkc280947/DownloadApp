package com.example.downloadapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.downloadapp.R
import com.example.downloadapp.common.getDownloadStatusText
import com.example.downloadapp.data.DataHelper
import com.example.downloadapp.model.DownloadItem
import kotlinx.android.synthetic.main.item_downloads.view.*

class DownloadItemAdapter(val itemListener: OnDownloadActionPerform): RecyclerView.Adapter<DownloadItemAdapter.ViewHolder>(){

    private val downloadItemList = mutableListOf<DownloadItem>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_downloads,parent,false))
    }

    override fun getItemCount(): Int {
        return downloadItemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(downloadItemList[position])
    }

    fun addDownloadableItems(newList: MutableList<DownloadItem>) {
        downloadItemList.addAll(newList)
    }

    fun updateDownloadId(downloadId: Int, position: Int) {
        downloadItemList[position].downloadId = downloadId
    }

    fun updateProgress(progressPercent: Long, position: Int) {
        downloadItemList[position].progress = progressPercent
        downloadItemList[position].status = DataHelper.DOWNLOADING
        notifyItemChanged(position)
    }

    fun onCancel(position: Int) {
        downloadItemList[position].progress = 0
        downloadItemList[position].status = DataHelper.STOP
        notifyItemChanged(position)
    }

    fun onDownloaded(position: Int) {
        downloadItemList[position].progress = 100
        downloadItemList[position].status = DataHelper.DOWNLOADED
        notifyItemChanged(position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.apply {
                buttonDownload.setOnClickListener {
                    itemListener.startDownload(downloadItemList[adapterPosition],adapterPosition)
                }

                buttonCancel.setOnClickListener {
                    itemListener.cancelDownload(downloadItemList[adapterPosition].downloadId)
                }
            }
        }

        fun bindView(item: DownloadItem){
            itemView.apply {
                textFileName.text = item.fileName
                textStatus.text =
                    getDownloadStatusText(item.status)
                if(item.status == DataHelper.DOWNLOADING){
                    progressDownload.progress = item.progress.toInt()
                    progressDownload.visibility = View.VISIBLE
                    buttonCancel.visibility = View.VISIBLE
                }else{
                    progressDownload.visibility = View.GONE
                    buttonCancel.visibility = View.GONE
                }

                if(item.status == DataHelper.DOWNLOADED || item.status == DataHelper.DOWNLOADING){
                    buttonDownload.visibility = View.GONE
                }else{
                    buttonDownload.visibility = View.VISIBLE
                }
            }
        }
    }

    interface OnDownloadActionPerform{
        fun startDownload(url: DownloadItem, position: Int)
        fun cancelDownload(downloadId: Int)
    }
}