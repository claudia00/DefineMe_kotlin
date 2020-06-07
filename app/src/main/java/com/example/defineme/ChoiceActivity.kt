package com.example.defineme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.defineme.foodExercise.ActiveActivity
import com.example.defineme.Custom_File.CustomActivity
import com.example.defineme.choreWheel.ChoreActivity
import kotlinx.android.synthetic.main.activity_choice.*

class ChoiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        active.setOnClickListener{
                val intent = Intent(this, ActiveActivity::class.java)
                startActivity(intent)
        }
        chore.setOnClickListener {
            val intent = Intent(this, ChoreActivity::class.java)
            startActivity(intent)
        }
        customButton.setOnClickListener{
            val intent = Intent(this, CustomActivity::class.java)
            startActivity(intent)
        }
    }
}
