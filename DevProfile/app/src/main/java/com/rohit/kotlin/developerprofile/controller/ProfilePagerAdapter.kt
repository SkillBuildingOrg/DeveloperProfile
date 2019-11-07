package com.rohit.kotlin.developerprofile.controller

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.rohit.kotlin.developerprofile.ui.fragments.AboutFragment
import com.rohit.kotlin.developerprofile.ui.fragments.ContactFragment
import com.rohit.kotlin.developerprofile.ui.fragments.SkillsFragment
import com.rohit.kotlin.developerprofile.ui.fragments.WorkFragment

class ProfilePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return AboutFragment()
            }
            1 -> {
                return SkillsFragment()
            }
            2 -> {
                return WorkFragment()
            }
            3 -> {
                return ContactFragment()
            }
        }
        return AboutFragment()
    }

    override fun getCount(): Int {
        // 4 tabs 4 fragments
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> return "SUMMERY"
            1 -> return "SKILLS"
            2 -> return "WORK"
            3 -> return "PERSONAL"
        }
        return super.getPageTitle(position)
    }
}