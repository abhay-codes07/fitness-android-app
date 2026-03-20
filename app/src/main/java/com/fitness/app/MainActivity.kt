package com.fitness.app

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private var caloriesBurned = 0
    private var stepsWalked = 0
    private var waterIntake = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
            
            sharedPreferences = getSharedPreferences("fitness_data", MODE_PRIVATE)
            loadData()

            // Get all views safely
            val tvTitle = findViewById<TextView>(R.id.tvTitle) ?: return
            val tvCalories = findViewById<TextView>(R.id.tvCalories) ?: return
            val tvSteps = findViewById<TextView>(R.id.tvSteps) ?: return
            val tvWater = findViewById<TextView>(R.id.tvWater) ?: return
            
            val etCalories = findViewById<EditText>(R.id.etCalories) ?: return
            val etSteps = findViewById<EditText>(R.id.etSteps) ?: return
            val etWater = findViewById<EditText>(R.id.etWater) ?: return
            
            val btnAddCalories = findViewById<Button>(R.id.btnAddCalories) ?: return
            val btnAddSteps = findViewById<Button>(R.id.btnAddSteps) ?: return
            val btnAddWater = findViewById<Button>(R.id.btnAddWater) ?: return
            val btnReset = findViewById<Button>(R.id.btnReset) ?: return

            updateUI(tvCalories, tvSteps, tvWater)
            tvTitle.text = "💪 Fitness Tracker 💪"

            btnAddCalories.setOnClickListener {
                try {
                    val input = etCalories.text.toString().trim()
                    if (input.isNotEmpty()) {
                        caloriesBurned += input.toInt()
                        saveData()
                        updateUI(tvCalories, tvSteps, tvWater)
                        etCalories.text.clear()
                        Toast.makeText(this, "✓ Calories Added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "⚠ Enter a value!", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "❌ Invalid input!", Toast.LENGTH_SHORT).show()
                }
            }

            btnAddSteps.setOnClickListener {
                try {
                    val input = etSteps.text.toString().trim()
                    if (input.isNotEmpty()) {
                        stepsWalked += input.toInt()
                        saveData()
                        updateUI(tvCalories, tvSteps, tvWater)
                        etSteps.text.clear()
                        Toast.makeText(this, "✓ Steps Added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "⚠ Enter a value!", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "❌ Invalid input!", Toast.LENGTH_SHORT).show()
                }
            }

            btnAddWater.setOnClickListener {
                try {
                    val input = etWater.text.toString().trim()
                    if (input.isNotEmpty()) {
                        waterIntake += input.toInt()
                        saveData()
                        updateUI(tvCalories, tvSteps, tvWater)
                        etWater.text.clear()
                        Toast.makeText(this, "✓ Water Added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "⚠ Enter a value!", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "❌ Invalid input!", Toast.LENGTH_SHORT).show()
                }
            }

            btnReset.setOnClickListener {
                try {
                    caloriesBurned = 0
                    stepsWalked = 0
                    waterIntake = 0
                    saveData()
                    updateUI(tvCalories, tvSteps, tvWater)
                    Toast.makeText(this, "✓ Data Reset!", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "❌ Error resetting data!", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error initializing app: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun updateUI(tvCalories: TextView, tvSteps: TextView, tvWater: TextView) {
        try {
            tvCalories.text = "🔥 Calories Burned: $caloriesBurned kcal"
            tvSteps.text = "👟 Steps Walked: $stepsWalked"
            tvWater.text = "💧 Water Intake: $waterIntake ml"
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun saveData() {
        try {
            with(sharedPreferences.edit()) {
                putInt("calories", caloriesBurned)
                putInt("steps", stepsWalked)
                putInt("water", waterIntake)
                apply()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun loadData() {
        try {
            caloriesBurned = sharedPreferences.getInt("calories", 0)
            stepsWalked = sharedPreferences.getInt("steps", 0)
            waterIntake = sharedPreferences.getInt("water", 0)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
