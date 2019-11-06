package com.rohit.kotlin.developerprofile.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohit.kotlin.developerprofile.R

class ProfileHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Profile"
    }
}
