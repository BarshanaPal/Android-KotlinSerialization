package com.wipro.demo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MigratedFrom(
    val on_date: Int,
    val other_site: OtherSite,
    val question_id: Int
)