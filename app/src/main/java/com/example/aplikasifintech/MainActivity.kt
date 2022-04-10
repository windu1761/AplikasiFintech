package com.example.aplikasifintech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.aplikasifintech.Home.HomeFragment
import com.example.aplikasifintech.Profile.ProfileFragment
import com.example.aplikasifintech.Settings.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnHome : Button
    private lateinit var btnProfile : Button
    private lateinit var btnSetting : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHome = findViewById(R.id.btn_home)
        btnProfile = findViewById(R.id.btn_profile)
        btnSetting = findViewById(R.id.btn_settings)

//       btnHome.setOnClickListener {
//            val intent = Intent ( this, HomeActivity::class.java)
//            intent.putExtra("username","windu")
//            startActivity(intent)
//         }
        btnHome.setOnClickListener{
            loadFragment(HomeFragment())
        }
        btnProfile.setOnClickListener {
            loadFragment(ProfileFragment())
        }
        btnSetting.setOnClickListener {
            loadFragment(SettingsFragment())
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commitNow()

    }
}