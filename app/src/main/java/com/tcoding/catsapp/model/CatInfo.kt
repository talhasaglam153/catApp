package com.tcoding.catsapp.model


class Cat: ArrayList<CatInfo>()

data class CatInfo(
    var name: String,
    var origin: String,
    var description: String,
    var image: CatImage?,
    var wikipedia_url: String?
    )

data class CatImage(
    var url: String
)
