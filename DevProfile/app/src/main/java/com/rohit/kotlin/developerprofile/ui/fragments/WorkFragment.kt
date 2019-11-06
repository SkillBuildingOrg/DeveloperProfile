package com.rohit.kotlin.developerprofile.ui.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rohit.kotlin.developerprofile.*
import com.rohit.kotlin.developerprofile.ui.activities.ProjectsActivity
import kotlinx.android.synthetic.main.fragment_work.view.*

/**
 * A simple [Fragment] subclass.
 */
class WorkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val workView = inflater.inflate(R.layout.fragment_work, container, false)

        workView.layoutCompanyTieto.setOnClickListener { getOnClickAction(it) }
        workView.layoutCompanyPersistent.setOnClickListener { getOnClickAction(it) }
        workView.layoutCompanySynerzip.setOnClickListener { getOnClickAction(it) }
        workView.layoutCompanyGeodesic.setOnClickListener { getOnClickAction(it) }
        workView.layoutCompanyMobilewin.setOnClickListener { getOnClickAction(it) }

        return workView
    }

    fun getOnClickAction(view: View) {
        var intentTag: String? = null
        when (view.id) {
            R.id.layoutCompanyTieto -> intentTag = KEY_COMPANY_TIETO
            R.id.layoutCompanyPersistent -> intentTag = KEY_COMPANY_PERSISTENT
            R.id.layoutCompanySynerzip -> intentTag = KEY_COMPANY_SYNERZIP
            R.id.layoutCompanyGeodesic -> intentTag = KEY_COMPANY_GEO
            R.id.layoutCompanyMobilewin -> intentTag = KEY_COMPANY_MOBILE
        }
        if (intentTag != null) {
            val projectIntent = Intent(activity, ProjectsActivity::class.java)
            projectIntent.putExtra(KEY_COMPANY_NAME, intentTag)
            activity?.startActivity(projectIntent)
        }
    }
}
