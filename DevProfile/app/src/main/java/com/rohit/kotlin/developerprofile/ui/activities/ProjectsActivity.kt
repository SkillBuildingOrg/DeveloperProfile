package com.rohit.kotlin.developerprofile.ui.activities

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rohit.kotlin.developerprofile.R
import com.rohit.kotlin.developerprofile.models.*
import com.rohit.kotlin.developerprofile.utils.*
import com.rohit.kotlin.developerprofile.utils.HTMLUtils.Companion.loadHtmlText
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.layout_project_info.view.*
import me.saket.bettermovementmethod.BetterLinkMovementMethod

class ProjectsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        supportActionBar!!.title = "KEY PROJECTS"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if(intent.extras != null) {
            val companyTag:String? = intent.extras!!.getString(KEY_COMPANY_NAME)
            if(companyTag.equals(KEY_COMPANY_TIETO)) {
                addTietoProjects()
            } else if(companyTag.equals(KEY_COMPANY_PERSISTENT)) {
                addPersistentProjects()
            } else if(companyTag.equals(KEY_COMPANY_SYNERZIP)) {
                addSynerzipProjects()
            } else if(companyTag.equals(KEY_COMPANY_GEO)) {
                addGeodesicProjects()
            } else if(companyTag.equals(KEY_COMPANY_MOBILE)) {
                addMobile2WinProjects()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun addTietoProjects() {
        val forexView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(forexView)
        loadHtmlText(forexhtml, forexView.projectInformation)

        val mtaView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(mtaView)
        loadHtmlText(nordeaMTAhtml, mtaView.projectInformation)

        val productDevView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(productDevView)
        loadHtmlText(productshtml, productDevView.projectInformation)
    }

    fun addPersistentProjects() {
        val castlightView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(castlightView)
        loadHtmlText(castlighthtml, castlightView.projectInformation)

        val titbitView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(titbitView)
        loadHtmlText(titbithtml, titbitView.projectInformation)

        val knectView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(knectView)
        loadHtmlText(knectHtml, knectView.projectInformation)
    }

    fun addSynerzipProjects() {
        val quickOfficeView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(quickOfficeView)
        loadHtmlText(quickOfficeHtml, quickOfficeView.projectInformation)
    }

    fun addGeodesicProjects() {
        val radioView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(radioView)
        loadHtmlText(munduRadioHtml, radioView.projectInformation)

        val widgetsView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(widgetsView)
        loadHtmlText(widgetsJ2meHtml, widgetsView.projectInformation)
    }

    fun addMobile2WinProjects() {
        val mobile2WinView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(mobile2WinView)
        loadHtmlText(mobile2winHtml, mobile2WinView.projectInformation)
    }
}
