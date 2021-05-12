package com.gillall.xyz.softdesign.sdtest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * INTRO
 * ui packages grouped for fast find related files
 * LIBRARIES:
 * retrofit > the almost default way of work with network calls, recommended by google
 * koin > In execution time dependency injection
 * glide > Easy image loader and cache
 * JETPACK
 * Databinding > no findviewbyid, easy access to views
 * Recyclerview > Support huge amount of items(Events) with low memory usage
 * OTHERS
 * BindingAdapters > Create functions for use while binding views
 * FUTURE TASKS
 * Use a Workmanager to fetch data periodically and update
 * Stop using the endpoint for get a single event, the data is already here.
 * Use Room to store data offline
 * Make app full screen
 * Extract strings, translations
 * Handle rotate if needed
 * Add loaders while fetch data
 * Setup navigation transitions
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    companion object {
        //log multiple variables, used in debug
        fun clg(vararg values: Any?) {
            if (values.isEmpty()) return
            var v = 1
            for (c in values) {
                if (v < values.size) {
                    v++
                    print(c.toString() + " ")
                } else {
                    println(c)
                }
            }
        }
    }
}