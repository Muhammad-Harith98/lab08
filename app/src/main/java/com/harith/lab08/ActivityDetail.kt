package com.harith.lab08

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.harith.lab08.databinding.ActivityDetailBinding

class ActivityDetail : AppCompatActivity()
{

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using ViewBinding
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.NameTextView.text = intent.getStringExtra("name")
        binding.PhoneTextView.text = intent.getStringExtra("phone")
        binding.SizeTextView.text = intent.getStringExtra("size")
        binding.dateTextView.text = intent.getStringExtra("date")
        binding.timeTextView.text = intent.getStringExtra("time")


        binding.sendBtn.setOnClickListener {

            binding.ratingTextView.text = binding.ratingBar.rating.toString()

            Snackbar.make(view, "Thank you for your rating, we have received it", Snackbar.LENGTH_SHORT)
                .setAction("OK") {

                    print("User pressed OK!")
                }
                .show()
        }
    }
}

