package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Items
import com.squareup.picasso.Picasso
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit


class MyAdapter(var context: Context, items: Array<Items>) :
    RecyclerView.Adapter<MyViewHolder>() {
    var items: Array<Items>
    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //val displaymetrics = DisplayMetrics()
        //val screenWidth: Int = displaymetrics.widthPixels
        val vidId:String=items[position].getId()!!.getVideoId()!!
        holder.textView.setText(items[position].getSnippet()!!.getTitle())
        holder.channelName.setText(items[position].getSnippet()!!.getChannelTitle())

        holder.time.setText(convert(items[position].getSnippet()!!.publishedAt!!))
        //holder.time.setText(items[position].getSnippet()!!.publishTime)
        //holder.textView1.setText(items[position].getId()!!.getVideoId())
        Picasso.get().load(items[position].getSnippet()!!.getThumbnails()!!.getHigh()!!.getUrl())
            .into(holder.imageView)
       //items[position].getSnippet()!!.getChannelId()
        holder.imageView.setOnClickListener { v ->
            var i=Intent(context,YtVideo::class.java)
            i.putExtra("video_id",vidId)
            v.context.startActivity(i)

        }



    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun convert(publishedDay: String): String {
        val formatPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val publishedAt = LocalDateTime.parse(publishedDay, formatPattern)

        val currentDate = LocalDateTime.now().withNano(0)

        val differenceInSeconds = ChronoUnit.SECONDS.between(publishedAt, currentDate)
        val differenceInDays = ChronoUnit.DAYS.between(publishedAt, currentDate)
        val differenceInMonths = ChronoUnit.MONTHS.between(publishedAt, currentDate)
        val differenceInYears=ChronoUnit.YEARS.between(publishedAt, currentDate)
        return findDifference(differenceInSeconds, differenceInDays, differenceInMonths,differenceInYears)
    }

    private fun findDifference(differenceInSeconds: Long, differenceInDays: Long, differenceInMonths: Long, differenceInYears:Long): String {
        val hours = differenceInSeconds / 3600
        when(differenceInDays) {
            in 21..31 -> {
                return "3 weeks ago"
            }
            in 14..20 -> {
                return "2 weeks ago"
            }
            in 2..13 -> {
                return "$differenceInDays days ago"
            }
            in 0..1 -> {
                return "$hours hours ago"
            }
        }
        if (differenceInMonths in 0..11) {
            return "$differenceInMonths month ago"
        }
        return "$differenceInYears years ago"
    }




    override fun getItemCount(): Int {
        return items.size
    }


}
