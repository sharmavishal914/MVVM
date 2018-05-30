package com.vishal.kotlinmvvm.testing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.vishal.kotlinmvvm.R
import com.vishal.kotlinmvvm.ui.login.BaseActivity
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

class TestActivity : BaseActivity() {

    lateinit var testViewModel: TestViewModel

    @Inject
    lateinit var testViewModelFactory: TestViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        testViewModel = ViewModelProviders.of(this, testViewModelFactory).get(TestViewModel::class.java!!)
        textView.setText(testViewModel.scoreTeamA.toString())



    }

    fun firstDuplicate(a: IntArray): Int {
        var duplicate_number = -1
        var duplicate_index = -1
        for (i in a.indices) {
            val number = a[i]
            for (j in a.indices) {
                if (i == j) {
                    continue
                }
                if (a[j] == number) {
                    if (duplicate_number == -1) {
                        duplicate_number = a[j]
                        duplicate_index = j
                    } else {
                        if (j < duplicate_index) {
                            duplicate_number = a[j]
                            duplicate_index = j
                        }
                    }
                }
            }
        }
        return duplicate_number
    }


    // An example of both reading and writing to the ViewModel
    fun addOneForTeamA(v: View) {
        testViewModel.scoreTeamA = testViewModel.scoreTeamA + 1
        textView.setText(testViewModel.scoreTeamA.toString());
    }
}
