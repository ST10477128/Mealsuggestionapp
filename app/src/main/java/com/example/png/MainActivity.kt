package com.example.mealsugeestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val suggestionText = findViewById<TextView>(R.id.suggestionText)
        val mealImage = findViewById<ImageView>(R.id.mealImage)

        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()
            val mealSuggestion = getMealSuggestion(timeOfDay)
            suggestionText.text = mealSuggestion

            // Set the corresponding image
            val imageResource = getMealImage(timeOfDay)
            mealImage.setImageResource(imageResource)
        }

        resetButton.setOnClickListener {
            timeInput.text.clear()
            suggestionText.text = ""
            mealImage.setImageResource(R.drawable.placeholder) // Reset to default image
        }
    }

    private fun getMealSuggestion(timeOfDay: String): String {
        return when (timeOfDay) {
            "06:00 to 09:00" -> "How about some pancakes and coffee or cereal"
            "09:00 to 11:00" -> "A smoothie or fruit salad would be great!"
            "12:00 to 14:00" -> "Try a healthy sandwich or a burger with a fresh juice"
            "14:00 to 16:00" -> "Maybe some cookies and a cup of tea or fresh juice?"
            "17:00 to 19:00" -> "Grilled chicken with veggies or pasta and mince would be great."
            "19:00 to 21:00" -> "How about ice cream or malva pudding"
            else -> "Please enter a valid time of day."
        }
    }

    private fun  getMealImage(timeOfDay: String) : Int {
        return when (timeOfDay) {
          "06:00 to 09:00" -> R.drawable.breakfast
          "09:00 to 11:00" -> R.drawable.midmorning
          "12:00 to 14:00" -> R.drawable.afternoon
          "14:00 to 16:00" -> R.drawable.midafternoon
          "17:00 to 19:00" -> R.drawable.dinner
          "19:00 to 21:00" -> R.drawable.afterdinner
          else -> R.drawable.placeholder
        }
    }
}