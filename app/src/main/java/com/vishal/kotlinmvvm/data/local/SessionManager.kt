package com.vishal.kotlinmvvm.data.local

import android.content.SharedPreferences

class SessionManager(var mSharedPreferences: SharedPreferences) {

    fun setValue(key: String, value: Any?) {
        when (value) {
            is String? -> edit({ it.putString(key, value) })
            is Int -> edit({ it.putInt(key, value) })
            is Boolean -> edit({ it.putBoolean(key, value) })
            is Float -> edit({ it.putFloat(key, value) })
            is Long -> edit({ it.putLong(key, value) })
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    inline fun edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = mSharedPreferences.edit()
        operation(editor)
        editor.apply()
    }

    inline fun <reified T : Any> get(key: String, defaultValue: T? = null): T? {
        return when (T::class) {
            String::class -> mSharedPreferences.getString(key, defaultValue as? String) as T?
            Int::class -> mSharedPreferences.getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> mSharedPreferences.getBoolean(key, defaultValue as? Boolean
                    ?: false) as T?
            Float::class -> mSharedPreferences.getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> mSharedPreferences.getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }
}