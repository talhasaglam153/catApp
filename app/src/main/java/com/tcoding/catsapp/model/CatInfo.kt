package com.tcoding.catsapp.model

data class CatInfo(
    var name: String,
    var origin: String,
    var description: String,
    var image: CatImage
    )

data class CatImage(
    var url: String
)
