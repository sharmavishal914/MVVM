package com.vishal.kotlinmvvm.util.binder

import android.databinding.BindingAdapter
import android.databinding.InverseBindingMethod
import android.databinding.InverseBindingMethods
import android.widget.EditText

@InverseBindingMethods(
        InverseBindingMethod(
                type = EditTextBinder::class,
                attribute = "android:setSelection",
                method = "setSelection"
        )
)
class EditTextBinder {
    companion object {
        @JvmStatic
        @BindingAdapter("android:setSelection")
        fun setSelection(editText: EditText, string: String) {
            editText.setText(string)
            editText.setSelection(string.length)
        }
    }
}