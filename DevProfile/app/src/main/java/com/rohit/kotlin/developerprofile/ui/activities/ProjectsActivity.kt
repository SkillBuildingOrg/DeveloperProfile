package com.rohit.kotlin.developerprofile.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import androidx.core.text.HtmlCompat
import androidx.core.text.toSpanned
import com.rohit.kotlin.developerprofile.KEY_COMPANY_NAME
import com.rohit.kotlin.developerprofile.KEY_COMPANY_TIETO
import com.rohit.kotlin.developerprofile.R
import kotlinx.android.synthetic.main.activity_projects.*
import kotlinx.android.synthetic.main.layout_project_info.*
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
//        forexView.projectNameText.text = HtmlCompat.fromHtml(getString(R.string.project_tieto_forex), HtmlCompat.FROM_HTML_MODE_LEGACY).toSpanned()
//        BetterLinkMovementMethod.linkifyHtml(forexView.projectNameText)
//        forexView.projectRoleText.text = getString(R.string.project_tieto_forex_role)
//        forexView.projectSkillSet.text = getString(R.string.project_tieto_forex_skills)
//        forexView.projectResponsibilities.text = HtmlCompat.fromHtml(getString(R.string.project_tieto_forex_responsibilities), HtmlCompat.FROM_HTML_MODE_LEGACY).toSpanned()

        val mtaView = layoutInflater.inflate(R.layout.layout_project_info, null)
        projectsContainerLayout.addView(mtaView)
//        mtaView.projectNameText.text = HtmlCompat.fromHtml(getString(R.string.project_tieto_mta), HtmlCompat.FROM_HTML_MODE_LEGACY).toSpanned()
//        BetterLinkMovementMethod.linkifyHtml(mtaView.projectNameText)
//        mtaView.projectRoleText.text = getString(R.string.project_tieto_mta_role)
//        mtaView.projectSkillSet.text = getString(R.string.project_tieto_mta_skills)
//        mtaView.projectResponsibilities.text = HtmlCompat.fromHtml(getString(R.string.project_tieto_mta_responsibilities), HtmlCompat.FROM_HTML_MODE_LEGACY).toSpanned()
    }
}
