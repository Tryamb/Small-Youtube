package com.example.myapplication.models

import com.example.myapplication.model2.Statistics

class Items {
    var snippet: Snippet? = null
    var kind: String? = null
    var etag: String? = null
    var id: Id? = null
    private var statistics: Statistics?=null
    @JvmName("getSnippet1")
    fun getSnippet(): Snippet? {
        return snippet
    }
    @JvmName("setSnippet1")
    fun setSnippet(snippet: Snippet?) {
        this.snippet = snippet
    }

    @JvmName("getKind1")
    fun getKind(): String? {
        return kind
    }

    @JvmName("setKind1")
    fun setKind(kind: String?) {
        this.kind = kind
    }

    @JvmName("getEtag1")
    fun getEtag(): String? {
        return etag
    }

    @JvmName("setEtag1")
    fun setEtag(etag: String?) {
        this.etag = etag
    }

    @JvmName("getId1")
    fun getId(): Id? {
        return id
    }

    @JvmName("setId1")
    fun setId(id: Id?) {
        this.id = id
    }

}