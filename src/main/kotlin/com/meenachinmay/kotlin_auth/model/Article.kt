package com.meenachinmay.kotlin_auth.model

import java.util.UUID

data class Article(
    val id: UUID,
    val title: String,
    val body: String,
)
