package com.example.defineme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login.setOnClickListener{
            val status = signIn(username.text.toString(), password.text.toString())
            if(status) {
                Toast.makeText(this, "Login successful", LENGTH_SHORT).show()
                val intent = Intent(this, ChoiceActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please enter username and password", LENGTH_LONG).show()
            }
        }
    }


    fun signIn(userName: String, passWord: String):Boolean{
        return userName.isNotEmpty() && passWord.isNotEmpty()
    }
}
