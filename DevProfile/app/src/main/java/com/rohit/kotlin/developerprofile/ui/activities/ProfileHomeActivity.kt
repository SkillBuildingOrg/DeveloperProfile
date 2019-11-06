package com.rohit.kotlin.developerprofile.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import com.rohit.kotlin.developerprofile.R
import me.saket.bettermovementmethod.BetterLinkMovementMethod

class ProfileHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_home)
        supportActionBar!!.title = "Profile"

        BetterLinkMovementMethod.linkify(Linkify.ALL, this)
    }
}
