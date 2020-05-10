package com.srokowski.pawelcv.data.dataSources

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesIdStorage(
    private val context: Context
) {
    fun getStoredCvId(): Int {
        return context.getSharedPreferences(CV_SHARED_PREFS_KEY, Context.MODE_PRIVATE).getInt(
            STORED_CV_ID_KEY, DEFAULT_ID
        )
    }

    fun storeCvId(id: Int) {
        context.getSharedPreferences(CV_SHARED_PREFS_KEY, Context.MODE_PRIVATE)
            .edit()
            .putInt(STORED_CV_ID_KEY, id)
            .apply()
    }

    companion object {
        const val CV_SHARED_PREFS_KEY = "CV_SHARED_PREFS_KEY"
        const val STORED_CV_ID_KEY = "STORED_CV_ID_KEY"
        const val DEFAULT_ID = -1
    }
}