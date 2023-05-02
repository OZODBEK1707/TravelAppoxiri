package com.rosh.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import com.rosh.travelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        val animFromButton = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom)
        val animFromLeft = AnimationUtils.loadAnimation(this, R.anim.anim_from_left)
        val animFromTop = AnimationUtils.loadAnimation(this, R.anim.anim_from_top)

        //setAnimation
        binding.cardView.animation = animFromButton
        binding.cardView2.animation = animFromButton
        binding.cardView3.animation = animFromButton
        binding.cardView4.animation = animFromButton
        binding.cardView5.animation = animFromButton
        binding.imageView.animation = animFromTop
        binding.textView.animation = animFromTop
        binding.textView2.animation = animFromTop
        binding.textView3.animation = animFromTop
        binding.textView4.animation = animFromTop
        binding.textView5.animation = animFromTop
        binding.searchView.animation = animFromLeft



        binding.cardView.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
        binding.cardView2.setOnClickListener {
            val intent = Intent(this@MainActivity, FourthActivity::class.java)
            startActivity(intent)
        }
        binding.cardView3.setOnClickListener {
            val intent = Intent(this@MainActivity, OltinchiActivity::class.java)
            startActivity(intent)
        }
        binding.cardView4.setOnClickListener {
            val intent = Intent(this@MainActivity, SakkizinchiActivity::class.java)
            startActivity(intent)
        }
        binding.cardView5.setOnClickListener {
            val intent = Intent(this@MainActivity, TenthActivity::class.java)
            startActivity(intent)
        }




    }
}