package com.wipro.demo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Styling(
    val link_color: String,
    val tag_background_color: String,
    val tag_foreground_color: String
)