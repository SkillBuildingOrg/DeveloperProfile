package com.rohit.kotlin.developerprofile.ui.activities

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.text.util.Linkify
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.rohit.kotlin.developerprofile.R
import com.rohit.kotlin.developerprofile.controller.ProfilePagerAdapter
import kotlinx.android.synthetic.main.activity_profile_home.*
import me.saket.bettermovementmethod.BetterLinkMovementMethod
import java.io.File
import java.io.FileOutputStream

class ProfileHomeActivity : AppCompatActivity() {
    val PERMISSION_REQ_CODE = 1001
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_home)
        supportActionBar!!.title = "PROFILE"

        BetterLinkMovementMethod.linkify(Linkify.ALL, this)

        val profilePagerAdapter = ProfilePagerAdapter(supportFragmentManager)
        profileViewPager.adapter = profilePagerAdapter

        profileTabLayout.setupWithViewPager(profileViewPager)
        profileTabLayout.setTabTextColors(Color.DKGRAY, ContextCompat.getColor(this, android.R.color.white))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuDownload) {
            if (checkPermissions()) { // Check for storage access permissions and proceed
                // Download the resume file on the device storage
                val bufferSize = 1024
                val assetManager = this.assets
                val assetFiles = assetManager.list("resume")
                Log.e("DOWNLOAD", "---------> List size : " + assetFiles?.size)
                try {
                    assetFiles?.forEach {
                        Log.e("DOWNLOAD", "---------> File Path : " + it.toString())
                        val inputStream = assetManager.open(it)
                        val fullPath = "/sdcard/Resume_Rohit/"
                        val dir = File(fullPath)
                        if (!dir.exists()) {
                            dir.mkdirs()
                        }
                        val outFile = File(fullPath, "RohitJoshi.docx")
                        if (outFile.exists()) {
                            outFile.delete()
                        }
                        outFile.createNewFile()

                        val outputStream = FileOutputStream(outFile)

                        try {
                            inputStream.copyTo(outputStream, bufferSize)
                        } finally {
                            inputStream.close()
                            outputStream.flush()
                            outputStream.close()
                        }
                    }
                } catch (e: Exception) {
                    Log.e("DOWNLOAD", "Exception in opening file..")
                    Toast.makeText(this, "Download failed..!", Toast.LENGTH_LONG).show()
                }
                val alertBuilder = AlertDialog.Builder(this)
                alertBuilder.setTitle("Download Complete")
                alertBuilder.setMessage("Resume file saved in folder\n \"/sdcard/Resume_Rohit/\" successfully.")
                alertBuilder.setPositiveButton("Ok") { dialog, p1 -> dialog?.dismiss() }
                alertBuilder.create().show()
            } else {
                // If permissions are not available then ask for it.
                ActivityCompat.requestPermissions(this,
                        arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE),
                        PERMISSION_REQ_CODE)
            }
        } else if (item.itemId == R.id.menuShareApp) {
            // Initiate Sharing the app link from PlayStore
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.rohit.kotlin.developerprofile");
            startActivity(Intent.createChooser(shareIntent, "Share PlayStore Link"))
        }
        super.onOptionsItemSelected(item)
        return true
    }

    fun checkPermissions(): Boolean {
        var isEnabled = false
        isEnabled = (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) && PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.READ_EXTERNAL_STORAGE))
        return isEnabled
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            PERMISSION_REQ_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.i("REQUEST_PERMISSION", "Permission has been denied by user")
                } else {
                    Log.i("REQUEST_PERMISSION", "Permission has been granted by user")
                }
            }
        }
    }
}
