package com.rohit.kotlin.developerprofile.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rohit.kotlin.developerprofile.KEY_COMPANY_NAME
import com.rohit.kotlin.developerprofile.R
import kotlinx.android.synthetic.main.activity_projects.*

class ProjectsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        supportActionBar!!.title = "Projects"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if(intent.extras != null) {
            val companyTag:String? = intent.extras!!.getString(KEY_COMPANY_NAME)
            textProjects.text = companyTag
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
