package com.wipro.demo.data.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer


@Serializable
data class UserResponse(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)
