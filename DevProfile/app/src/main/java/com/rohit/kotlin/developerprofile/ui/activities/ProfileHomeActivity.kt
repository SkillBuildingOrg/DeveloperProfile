package com.rohit.kotlin.developerprofile.ui.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import androidx.core.content.ContextCompat
import com.rohit.kotlin.developerprofile.R
import com.rohit.kotlin.developerprofile.controller.ProfilePagerAdapter
import kotlinx.android.synthetic.main.activity_profile_home.*
import me.saket.bettermovementmethod.BetterLinkMovementMethod

class ProfileHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_home)
        supportActionBar!!.title = "Profile"

        BetterLinkMovementMethod.linkify(Linkify.ALL, this)

        val profilePagerAdapter = ProfilePagerAdapter(supportFragmentManager)
        profileViewPager.adapter = profilePagerAdapter

        profileTabLayout.setupWithViewPager(profileViewPager)
        profileTabLayout.setTabTextColors(Color.DKGRAY, ContextCompat.getColor(this, android.R.color.white))
    }
}
