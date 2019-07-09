package com.example.zoopractice.model

data class Result(
    val count: Int? = 0,
    val limit: Int? = 0,
    val offset: Int? = 0,
    val results: List<ResultX?>? = listOf(),
    val sort: String? = ""
)