package com.example.defineme

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var translateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate()
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

        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)

        translateButton = findViewById(R.id.translateChange)

        translateButton.setOnClickListener {

            translateTime()
        }

    }

    fun signIn(userName: String, passWord: String):Boolean{
        return userName.isNotEmpty() && passWord.isNotEmpty()
    }
    private fun translateTime(){
        val languageSelection = arrayOf("English","Espanol","Français")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(languageSelection, -1) { dialog, which ->
            if (which == 0) {
                setLocate("en")
                recreate()
            }else if(which == 1){
                setLocate("es")
                recreate()
        }else if(which == 2){
                setLocate("fr")
                recreate()
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocate(Lang:String){
        val locale = Locale(Lang)
        Locale.setDefault(locale)

        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("Language", Lang)
        editor.apply()
    }

    private fun loadLocate(){
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("Language", "")
        if (language != null) {
            setLocate(language)
        }
    }

}
