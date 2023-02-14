package com.example.myapplication.models

class Thumbnails {
    var defaul: Default? = null
    var high: High? = null
    var medium: Medium? = null
    @JvmName("getDefault1")
    fun getDefault(): Default? {
        return defaul
    }

    fun setDefault(defaul: Default?) {
        this.defaul = defaul
    }

    @JvmName("getHigh1")
    fun getHigh(): High? {
        return high
    }

    @JvmName("setHigh1")
    fun setHigh(high: High?) {
        this.high = high
    }

    @JvmName("getMedium1")
    fun getMedium(): Medium? {
        return medium
    }

    @JvmName("setMedium1")
    fun setMedium(medium: Medium?) {
        this.medium = medium
    }
}