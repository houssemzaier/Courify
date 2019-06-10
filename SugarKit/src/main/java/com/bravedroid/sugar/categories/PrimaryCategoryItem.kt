package com.bravedroid.sugar.categories

data class PrimaryCategoryItem(
    val id: String,
    val title: String,
    val categoryThumbnailUrl: String? = null,
    val onClick: (() -> Unit)? = null
)
