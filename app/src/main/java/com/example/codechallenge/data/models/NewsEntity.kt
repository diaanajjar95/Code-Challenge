package com.example.codechallenge.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "published_date") var publishedDate: String?,
    @ColumnInfo(name = "section") val section: String?,
    @ColumnInfo(name = "source") val source: String?,
    @ColumnInfo(name = "subsection") val subsection: String?,
    @ColumnInfo(name = "updated") val updated: String?,
    @ColumnInfo(name = "image_url") val imageUrl: String?,
)


