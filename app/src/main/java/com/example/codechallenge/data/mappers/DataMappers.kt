package com.example.codechallenge.data.mappers

import com.example.codechallenge.data.models.NewsEntity
import com.example.codechallenge.data.models.NewsItem

fun NewsItem.toEntity(): NewsEntity {
    val newsImageUrl: String? = media?.firstOrNull()?.mediaMetadata?.firstOrNull()?.url
    return NewsEntity(
        title = title,
        type = type,
        publishedDate = publishedDate,
        section = section,
        source = source,
        subsection = subsection,
        updated = updated,
        imageUrl = newsImageUrl
    )
}