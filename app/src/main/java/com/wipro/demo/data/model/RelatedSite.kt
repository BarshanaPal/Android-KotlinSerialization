package com.wipro.demo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RelatedSite(
    val api_site_parameter: String,
    val name: String,
    val relation: String,
    val site_url: String
)