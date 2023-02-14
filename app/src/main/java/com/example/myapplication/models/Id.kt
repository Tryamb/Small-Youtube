package com.example.myapplication.models

class Id {
    var kind: String? = null
    var videoId: String? = null
    @JvmName("getKind1")
    fun getKind(): String? {
        return kind
    }

    @JvmName("setKind1")
    fun setKind(kind: String?) {
        this.kind = kind
    }

    @JvmName("getVideoId1")
    fun getVideoId(): String? {
        return videoId
    }

    @JvmName("setVideoId1")
    fun setVideoId(videoId: String?) {
        this.videoId = videoId
    }
}