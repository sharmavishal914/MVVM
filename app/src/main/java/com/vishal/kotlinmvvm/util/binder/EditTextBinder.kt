package com.vishal.kotlinmvvm.util.binder

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.widget.EditText

@BindingAdapter("android:setSelection")
fun setSelectionEditText(editText: EditText, oldvalue: String?, newvalue: String?) {
    if (oldvalue == null) {
        editText.setText(newvalue)
        editText.setSelection(newvalue!!.length)
    }

}