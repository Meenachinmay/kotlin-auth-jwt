package com.meenachinmay.kotlin_auth.service

import com.meenachinmay.kotlin_auth.model.Article
import com.meenachinmay.kotlin_auth.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(private val articleRepository: ArticleRepository) {
    fun findAll(): List<Article> = articleRepository.findAll()
}