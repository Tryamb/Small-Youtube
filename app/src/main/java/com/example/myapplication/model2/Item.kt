package com.example.myapplication.model2

class Item {
    var kind: String? = null
    var etag: String? = null
    var id: String? = null
    private var statistics: Statistics? = null
    fun getStatistics(): Statistics? {
        return statistics
    }
}