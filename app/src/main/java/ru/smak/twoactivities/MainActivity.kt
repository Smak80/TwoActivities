package ru.smak.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var e_text: EditText
    var startCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button)
        e_text = findViewById(R.id.name)
        btn.setOnClickListener {
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra(Constants.STRING_KEY, e_text.text.toString())
            i.putExtra(Constants.INT_KEY, startCount++)
            startActivityForResult(i, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val res = data?.getStringExtra(Constants.RESULT_KEY)
        e_text.setText(res)
    }
}