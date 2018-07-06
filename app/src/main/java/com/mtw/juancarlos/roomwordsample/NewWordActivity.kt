package com.mtw.juancarlos.roomwordsample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_new_word.*

class NewWordActivity : AppCompatActivity() {

    companion object {
        val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        button_save.setOnClickListener {
            val replyIntent = Intent()
            val isNotEmpty:(TextView) -> Boolean = { it.text.isNotEmpty() }
            if (isNotEmpty(edit_word)){
                val word = edit_word.text.toString()
                replyIntent.putExtra(EXTRA_REPLY,word)
                setResult(Activity.RESULT_OK,replyIntent)
            } else {
                setResult(Activity.RESULT_CANCELED,replyIntent)
            }
            finish()
        }

    }
}
