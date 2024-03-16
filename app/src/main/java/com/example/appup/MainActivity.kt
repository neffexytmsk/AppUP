package com.example.appup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val btn_start = findViewById<Button>(R.id.btn_start)
        val et_name = findViewById<EditText>(R.id.et_name)
        val btn_go_to_list = findViewById<ImageView>(R.id.go_to_list_country)
        btn_start.setOnClickListener{
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this,"Вы забыли ввести имя и возраст",Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent=Intent(this@MainActivity,IqQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
        btn_go_to_list.setOnClickListener{
            startActivity(Intent(this@MainActivity,CountryActivity::class.java))
            finish()
        }

    }

}
