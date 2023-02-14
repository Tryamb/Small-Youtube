package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.API.SingltonRetrofitObject
import com.example.myapplication.models.Items
import com.example.myapplication.models.VideoModel
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var profileView: ImageView? = null
    var progressBar: ProgressBar? = null
    var user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        profileView=findViewById(R.id.profile)

        findViewById<ImageView>(R.id.search_icon).setOnClickListener{
            var v=findViewById<LinearLayout>(R.id.search_bar).visibility
            if(v==View.GONE) {
                findViewById<LinearLayout>(R.id.search_bar).visibility = View.VISIBLE
            }
            else
            {
                findViewById<LinearLayout>(R.id.search_bar).visibility = View.GONE
            }
        }

        findViewById<ImageView>(R.id.search).setOnClickListener{
            val query:String=findViewById<EditText>(R.id.et).getText().toString()
            videoSearch(query)
        }

        if (user!=null)
        {
            //profileView?.visibility=View.GONE
           // myProfile?.visibility=View.VISIBLE
            Picasso.get().load(user!!.photoUrl)
                .into(profileView)
        }

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progress_circular)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))
        recyclerView!!.hasFixedSize()
        doApiCall()
    }

    private fun videoSearch(query: String) {
        val videoModelCall: Call<VideoModel> =
            SingltonRetrofitObject.getmInstance()!!.getAPI()!!.getSearchedVideos(
                getString(R.string.youtubeAPIKey),
                "", "snippet", "relevance", "50", "video","$query"
            )
        videoModelCall.enqueue(object : Callback<VideoModel> {
            override fun onResponse(call: Call<VideoModel>, response: Response<VideoModel>) {
                setRecyclerView(response.body()!!.getItems())
            }

            override fun onFailure(call: Call<VideoModel>, t: Throwable) {
                recyclerView!!.visibility=View.GONE
                Toast.makeText(this@MainActivity,"API Exception ERROR",Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun doApiCall() {
        val videoModelCall: Call<VideoModel> =
            SingltonRetrofitObject.getmInstance()!!.getAPI()!!.getVideoDetails(
                getString(R.string.youtubeAPIKey),
                "snippet", "relevance", "50", "video"
            )
        videoModelCall.enqueue(object : Callback<VideoModel> {
            override fun onResponse(call: Call<VideoModel>, response: Response<VideoModel>) {
                setRecyclerView(response.body()!!.getItems())
            }

            override fun onFailure(call: Call<VideoModel>, t: Throwable) {}
        })
    }

    private fun setRecyclerView(items: Array<Items>) {
        val myAdapter = MyAdapter(this, items)
        recyclerView!!.adapter = myAdapter
        recyclerView!!.visibility = View.VISIBLE
        progressBar!!.visibility = View.GONE
    }

    fun profile(view: View)
    {
        var i=Intent(this@MainActivity,LoginScreen::class.java)
        startActivity(i)
    }




}