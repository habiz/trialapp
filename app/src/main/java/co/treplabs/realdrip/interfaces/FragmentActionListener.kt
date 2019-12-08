package co.treplabs.realdrip.interfaces

import android.content.Intent

interface FragmentActionListener {
    fun onFragmentAction(action: String, intent: Intent?)
}