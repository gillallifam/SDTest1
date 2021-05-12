package com.gillall.xyz.softdesign.sdtest1.model

data class SDEvent (
    var people: List<CheckIn>?,
    var date: Int?,
    var description: String?,
    var image: String,
    var longitude: Double?,
    var latitude: Double?,
    var price: Double?,
    var title: String?,
    val id: String?
)