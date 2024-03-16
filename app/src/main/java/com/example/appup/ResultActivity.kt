package com.example.appup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN



        val userName = intent.getStringExtra(Constants.USER_NAME)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        tv_name.text = userName
        val tv_score = findViewById<TextView>(R.id.tv_score)
        val btn_finish = findViewById<TextView>(R.id.btn_finish)



        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val tv_congratulations = findViewById<TextView>(R.id.tv_congratulations)

        val formula = correctAnswers.toDouble()/totalQuestions.toDouble()
        when (formula) {
            in 0.0..0.5 -> {
                tv_congratulations.text = "Вы отсталый!"
            }
            in 0.5..0.8 -> {
                tv_congratulations.text = "Вы средне!"
            }

            else -> {
                tv_congratulations.text = "Вы гениальны!"
            }
        }


        tv_score.text = "Вы набрали $correctAnswers из $totalQuestions."

        btn_finish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }
}
