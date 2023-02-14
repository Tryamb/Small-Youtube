package com.example.myapplication.model2

import android.content.ClipData.Item
import com.example.myapplication.models.PageInfo


class VideoStats {
    private var kind: String? = null
    private var etag: String? = null
    private var items: List<Item> = ArrayList()
    private var pageInfo: PageInfo? = null
    fun getKind(): String? {
        return kind
    }

    fun getEtag(): String? {
        return etag
    }


    fun getItems(): List<Item?>? {
        return items
    }


    fun getPageInfo(): PageInfo? {
        return pageInfo
    }

}