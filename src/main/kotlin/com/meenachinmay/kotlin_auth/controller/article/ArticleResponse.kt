package com.meenachinmay.kotlin_auth.controller.article

import java.util.*

data class ArticleResponse(
    val id: UUID,
    val title: String,
    val body: String,
)
