package com.example.aplikasifintech.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.aplikasifintech.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        title = "Menu Profile"
        val nama = findViewById<TextView>(R.id.tvnama)
        val nim = findViewById<TextView>(R.id.tvnim)
        val email = findViewById<TextView>(R.id.tvemail)
        val hp = findViewById<TextView>(R.id.tvhp)
        val jenkel = findViewById<TextView>(R.id.tvjk)
        val prodi = findViewById<TextView>(R.id.tvprodi)
        val org = findViewById<TextView>(R.id.tvorg)
        val status = findViewById<TextView>(R.id.tvsm)

        val bukabundle = intent.extras
        if (bukabundle != null) {
            nama.setText(bukabundle.getString("nama"))
            nim.setText(bukabundle.getString("nim"))
            email.setText(bukabundle.getString("email"))
            hp.setText(bukabundle.getString("hp"))
            jenkel.setText(bukabundle.getString("jenkel"))
            prodi.setText(bukabundle.getString("prodi"))
            org.setText(bukabundle.getString("org"))
            status.setText(bukabundle.getString("status"))
        }
    }
}