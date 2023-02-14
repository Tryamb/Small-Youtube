package com.example.myapplication.model2

class Statistics {
    private val viewCount: String? = null
    private val likeCount: String? = null
    private val favoriteCount: String? = null
    private val commentCount: String? = null

        @JvmName("viewCount")
        fun getViewCount(): String? {
            return viewCount
        }


        fun getLikeCount(): String? {
            return likeCount
        }


        fun getFavoriteCount(): String? {
            return favoriteCount
        }

        fun getCommentCount(): String? {
            return commentCount
        }

}