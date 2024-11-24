package com.harith.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.harith.lab08.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pizzaSize = arrayOf("Small", "Medium", "Large")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.sizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.sizeTextView.text = pizzaSize[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                print("Stop Tracking")

            }
        })

        binding.scheduleBtn.setOnClickListener {
            val intent = Intent(this, ActivityDetail::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("phone", binding.phoneEditText.text.toString())
            intent.putExtra("size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())
            startActivity(intent)
        }


        binding.dateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                binding.dateTextView.text = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            }, year, month, day)
            datePickerDialog.show()
        }

        binding.timeButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                binding.timeTextView.text = String.format("%02d:%02d", selectedHour, selectedMinute)
            }, hour, minute, true)
            timePickerDialog.show()
        }
    }
}
