package com.waitinglobby.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_preview.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_job_title.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_my_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_start_date.text?.toString()
        )


        //Think of an Intent like a letter. You write on the letter who the letter is from (1st parameter says from 'this screen'
        // second parameter is who to? and then we give that to the postman which is the Android system (startActivity)
        // postman looks at the letter and decides what to do with it. In this case postman looks in the manifest (address book), sees the two activities and off it goes to that new activity and commands it to start
        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

        startActivity(previewActivityIntent)
    }
}