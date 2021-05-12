package com.gillall.xyz.softdesign.sdtest1.data.remote

import com.gillall.xyz.softdesign.sdtest1.model.CheckIn
import com.gillall.xyz.softdesign.sdtest1.model.SDEvent
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface SDService {
    @GET("events")
    suspend fun getEvents(): List<SDEvent>

    @GET("events/{id}")
    suspend fun getEvent(@Path("id") id: String?): SDEvent

    @POST("checkin")
    suspend fun checkIn(@Body checkin: CheckIn)
}