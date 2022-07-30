package com.example.appselect.models

data class ResponseApi(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<ResponseItem>,
    val status: String
)