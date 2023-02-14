package com.example.myapplication.models

class PageInfo {
    var totalResults: String? = null
    var resultsPerPage: String? = null
    @JvmName("getTotalResults1")
    fun getTotalResults(): String? {
        return totalResults
    }

    @JvmName("setTotalResults1")
    fun setTotalResults(totalResults: String?) {
        this.totalResults = totalResults
    }

    @JvmName("getResultsPerPage1")
    fun getResultsPerPage(): String? {
        return resultsPerPage
    }

    @JvmName("setResultsPerPage1")
    fun setResultsPerPage(resultsPerPage: String?) {
        this.resultsPerPage = resultsPerPage
    }
}