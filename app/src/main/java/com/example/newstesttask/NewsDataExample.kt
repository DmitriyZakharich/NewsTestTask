package com.example.newstesttask

data class NewsDataExample(
    val articles: List<ArticleExample>,
    val status: String,
    val totalResults: Int
)

data class ArticleExample(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceExample,
    val title: String,
    val url: String,
    val urlToImage: String
)

data class SourceExample(
    val id: String,
    val name: String
)