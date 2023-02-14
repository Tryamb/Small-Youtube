package com.example.myapplication
import android.os.Bundle
import android.support.annotation.NonNull
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.API.SingltonRetrofitObject2
import com.example.myapplication.model2.VideoStats
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class YtVideo : AppCompatActivity() {
    var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yt_video)

        textView = findViewById(R.id.views)
        val youTubePlayerView = findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        /*findViewById<Button>(R.id.fullscreen_button).setOnClickListener{

        }*/


        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId: String = intent.extras?.getString("video_id")!!
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
        findViewById<Button>(R.id.fullscreen_button).setOnClickListener{
            //getStats()
        }



    }

    private fun getStats() {
        val videoId: String = intent.extras?.getString("video_id")!!
        val videoStatsCall: Call<VideoStats> =
            SingltonRetrofitObject2.getmInstance()!!.getAPI()!!.statistics(
                "$videoId",
                "statistics","AIzaSyDtThfaOPo-uaG3n2RCibzR82C35cer6o4"
            )
        videoStatsCall.enqueue(object : Callback<VideoStats> {
            override fun onResponse(call: Call<VideoStats>, response: Response<VideoStats>) {

                val responseFromAPI = response.body()
                val responseString = """  //currently response body is null
                    Response Code : ${response.code()}
                    Name : ${responseFromAPI!!.getEtag().toString()}
                    """.trimIndent()
                textView!!.setText(response.body()!!.getEtag())
                Toast.makeText(this@YtVideo,"Working Fine",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<VideoStats>, t: Throwable) {
                Toast.makeText(this@YtVideo,"Not Working",Toast.LENGTH_SHORT).show()
            }
        })
    }




}