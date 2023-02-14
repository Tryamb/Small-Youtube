package com.example.myapplication.models

class Default {
    var width: String? = null
    var url: String? = null
    var height: String? = null
    @JvmName("getWidth1")
    fun getWidth(): String? {
        return width
    }

    @JvmName("setWidth1")
    fun setWidth(width: String?) {
        this.width = width
    }

    @JvmName("getUrl1")
    fun getUrl(): String? {
        return url
    }

    @JvmName("setUrl1")
    fun setUrl(url: String?) {
        this.url = url
    }

    @JvmName("getHeight1")
    fun getHeight(): String? {
        return height
    }

    @JvmName("setHeight1")
    fun setHeight(height: String?) {
        this.height = height
    }
}