package ru.smak.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var tv: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extra_string = intent.getStringExtra(Constants.STRING_KEY)
        val start = intent.getIntExtra(Constants.INT_KEY, 0)
        tv = findViewById(R.id.editText)
        tv.setText(getString(R.string.second_activity_text_view_text, start, extra_string))
        tv.setOnKeyListener { v, keyCode, event ->
            val i = Intent()
            i.putExtra(Constants.RESULT_KEY, tv.text.toString())
            setResult(0, i)
            false
        }
    }
}