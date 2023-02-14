package com.example.myapplication.model2

class PageInfo {
    private var totalResults: Int? = null
    private var resultsPerPage: Int? = null
    fun getTotalResults(): Int? {
        return totalResults
    }

    fun setTotalResults(totalResults: Int?) {
        this.totalResults = totalResults
    }

    fun getResultsPerPage(): Int? {
        return resultsPerPage
    }

    fun setResultsPerPage(resultsPerPage: Int?) {
        this.resultsPerPage = resultsPerPage
    }
}