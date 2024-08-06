package com.meenachinmay.kotlin_auth.repository

import com.meenachinmay.kotlin_auth.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {
    private val articles: MutableList<Article> = mutableListOf(
        Article(id = UUID.randomUUID(), title = "First Article", body = "This is first body"),
        Article(id = UUID.randomUUID(), title = "Second Article", body = "This is second body"),
    )

    fun findAll(): List<Article> =
        articles
}