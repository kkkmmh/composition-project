package com.mojak.app.domain.entity

data class Sheet(
    val sheetId: Long? = null,
    val userId: Long? = null,
    val sheetName: String,
    val bpm: Int,
    val timeSignature: String,
    val scale: String,
)