package com.nghia.androidtextinputlayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var errorInputLayout: TextInputLayout? = null
    var errorEditText: TextInputEditText? = null
    var customErrorInputLayout: TextInputLayout? = null
    var customErrorEditText: TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        errorEditText = findViewById(R.id.errorEditText)
        errorInputLayout = findViewById(R.id.errorInputLayout)

        customErrorEditText = findViewById(R.id.customErrorEditText)
        customErrorInputLayout = findViewById(R.id.customErrorInputLayout)

        errorEditText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.length > errorInputLayout!!.counterMaxLength)
                    errorInputLayout!!.error = "Max character length is " + errorInputLayout!!.counterMaxLength
                else errorInputLayout!!.error = null
            }
        })

        customErrorEditText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.length > customErrorInputLayout!!.counterMaxLength)
                    customErrorInputLayout!!.error = "Max character length is " + customErrorInputLayout!!.counterMaxLength
                else customErrorInputLayout!!.error = null
            }
        })
    }
}
