package com.example.myapplication.models

class Snippet {
    var publishTime: String? = null
    var publishedAt: String? = null
    var description: String? = null
    var title: String? = null
    var thumbnails: Thumbnails? = null
    var channelId: String? = null
    var channelTitle: String? = null
    var liveBroadcastContent: String? = null
    @JvmName("getPublishTime1")
    fun getPublishTime(): String? {
        return publishTime
    }

    @JvmName("setPublishTime1")
    fun setPublishTime(publishTime: String?) {
        this.publishTime = publishTime
    }

    @JvmName("getPublishedAt1")
    fun getPublishedAt(): String? {
        return publishedAt
    }

    @JvmName("setPublishedAt1")
    fun setPublishedAt(publishedAt: String?) {
        this.publishedAt = publishedAt
    }

    @JvmName("getDescription1")
    fun getDescription(): String? {
        return description
    }

    @JvmName("setDescription1")
    fun setDescription(description: String?) {
        this.description = description
    }


    @JvmName("setThumbnails1")
    fun setThumbnails(thumbnails: Thumbnails?) {
        this.thumbnails = thumbnails
    }

    @JvmName("getChannelId1")
    fun getChannelId(): String? {
        return channelId
    }

    @JvmName("setChannelId1")
    fun setChannelId(channelId: String?) {
        this.channelId = channelId
    }

    @JvmName("getChannelTitle1")
    fun getChannelTitle(): String? {
        return channelTitle
    }

    @JvmName("setChannelTitle1")
    fun setChannelTitle(channelTitle: String?) {
        this.channelTitle = channelTitle
    }

    @JvmName("getLiveBroadcastContent1")
    fun getLiveBroadcastContent(): String? {
        return liveBroadcastContent
    }

    @JvmName("setLiveBroadcastContent1")
    fun setLiveBroadcastContent(liveBroadcastContent: String?) {
        this.liveBroadcastContent = liveBroadcastContent
    }

    @JvmName("getTitle1")
    fun getTitle(): String? {
        return title
    }

    @JvmName("setTitle1")
    fun setTitle(title: String?) {
        this.title = title
    }

    @JvmName("getThumbnails1")
    fun getThumbnails(): Thumbnails? {
        return thumbnails
    }
}

