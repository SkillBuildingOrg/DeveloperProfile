package com.rohit.kotlin.developerprofile.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rohit.kotlin.developerprofile.R
import com.rohit.kotlin.developerprofile.models.skillsHtml
import com.rohit.kotlin.developerprofile.utils.HTMLUtils
import kotlinx.android.synthetic.main.fragment_skills.view.*

/**
 * A simple [Fragment] subclass.
 */
class SkillsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val skillsView = inflater.inflate(R.layout.fragment_skills, container, false)
        HTMLUtils.loadHtmlText(skillsHtml, skillsView.skillsSummeryText)
        return skillsView
    }
}
