package com.vishal.kotlinmvvm.util

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


fun EditText.setTextCursor(s: String) {
    this.setText(s)
    this.setSelection(s.length)
}

fun ImageView.setVisible(b: Boolean) {
    if (b) {
        if (this.visibility != View.VISIBLE) {
            this.visibility = View.VISIBLE
        }
    } else {
        if (this.visibility != View.GONE) {
            this.visibility = View.GONE
        }
    }
}

fun TextView.setTextAutoCapital(value: String) {
    this.setText(value.substring(0, 1).toUpperCase() + value.substring(1))
}


fun String?.emptyStringIfNull(): String {
    if (this == null) {
        return ""
    } else {
        return this
    }
}
