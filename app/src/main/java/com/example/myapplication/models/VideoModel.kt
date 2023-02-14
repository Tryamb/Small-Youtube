package com.example.myapplication.models

class VideoModel {
    var regionCode: String? = null
    var kind: String? = null
    var nextPageToken: String? = null
    var pageInfo: PageInfo? = null
    var etag: String? = null
    lateinit var items: Array<Items>
    @JvmName("getRegionCode1")
    fun getRegionCode(): String? {
        return regionCode
    }

    @JvmName("setRegionCode1")
    fun setRegionCode(regionCode: String?) {
        this.regionCode = regionCode
    }

    @JvmName("getKind1")
    fun getKind(): String? {
        return kind
    }

    @JvmName("setKind1")
    fun setKind(kind: String?) {
        this.kind = kind
    }

    @JvmName("getNextPageToken1")
    fun getNextPageToken(): String? {
        return nextPageToken
    }

    @JvmName("setNextPageToken1")
    fun setNextPageToken(nextPageToken: String?) {
        this.nextPageToken = nextPageToken
    }

    @JvmName("getPageInfo1")
    fun getPageInfo(): PageInfo? {
        return pageInfo
    }

    @JvmName("setPageInfo1")
    fun setPageInfo(pageInfo: PageInfo?) {
        this.pageInfo = pageInfo
    }

    @JvmName("getEtag1")
    fun getEtag(): String? {
        return etag
    }

    @JvmName("setEtag1")
    fun setEtag(etag: String?) {
        this.etag = etag
    }

    @JvmName("getItems1")
    fun getItems(): Array<Items> {
        return items
    }
    @JvmName("setItems1")
    fun setItems(items: Array<Items>) {
        this.items = items
    }
}
