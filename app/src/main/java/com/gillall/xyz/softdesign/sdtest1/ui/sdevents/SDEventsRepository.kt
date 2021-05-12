package com.gillall.xyz.softdesign.sdtest1.ui.sdevents

import com.gillall.xyz.softdesign.sdtest1.data.remote.SDService
import com.gillall.xyz.softdesign.sdtest1.model.CheckIn
import com.gillall.xyz.softdesign.sdtest1.model.SDEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SDEventsRepository(private val sdService: SDService) {

    suspend fun getEvents(): List<SDEvent> {
        return try {
            sdService.getEvents()
        } catch (e: Exception) {
            mutableListOf()//empty list
        }
    }

    suspend fun getEvent(id: String?): SDEvent? {
        return try {
            sdService.getEvent(id)
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun checkIN(data: CheckIn): Boolean {
        return try {
            sdService.checkIn(data)
            return true
        } catch (e: Exception) {
            false
        }
    }
}