package com.example.newstesttask.domain

import com.example.newstesttask.domain.models.ArticleDomain
import com.example.newstesttask.domain.models.NewsDataDomain
import com.example.newstesttask.domain.models.SourceDomain
import com.example.newstesttask.repository.models.Article
import com.example.newstesttask.repository.models.NewsData
import com.example.newstesttask.repository.models.Source

fun mapperRepositoryToDomain(newsData: NewsData) = NewsDataDomain(
    articles = mapperList(newsData.articles),
    status = newsData.status,
    totalResults = newsData.totalResults)

fun mapperList(articles: List<Article>?): List<ArticleDomain> {
    val articleDomain = mutableListOf<ArticleDomain>()
    articles?.forEach {
        articleDomain.add(mapperRepositoryArticlesToDomainArticles(it))
    }
    return articleDomain
}

fun mapperRepositoryArticlesToDomainArticles(article: Article) =
    ArticleDomain(
        author = article.author,
        content = article.content,
        description = article.description,
        publishedAt = article.publishedAt,
        source = mapperRepositorySourceToSourceDomain(article.source),
        title = article.title,
        url = article.url, urlToImage = article.urlToImage)

fun mapperRepositorySourceToSourceDomain(source: Source?) =
    SourceDomain(
        id = source?.id,
        name = source?.name)