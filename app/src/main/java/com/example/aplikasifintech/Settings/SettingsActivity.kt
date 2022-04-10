package com.example.aplikasifintech.Settings

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.example.aplikasifintech.Profile.ProfileActivity
import com.example.aplikasifintech.R
import org.w3c.dom.Text


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        title = "Menu Setting"
        val btnsimpan = findViewById<Button>(R.id.btnsimpan)
        val nama = findViewById<EditText>(R.id.etnamalkp)
        val nim = findViewById<EditText>(R.id.etnim)
        val email = findViewById<EditText>(R.id.etemail)
        val hp = findViewById<EditText>(R.id.ethp)
        val password = findViewById<EditText>(R.id.etpassword)
        val jenkel = findViewById<RadioGroup>(R.id.rgjenkel)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val hmssi = findViewById<CheckBox>(R.id.himssi)
        val bem = findViewById<CheckBox>(R.id.bemamikom)
        val togglebtn = findViewById<ToggleButton>(R.id.togglebtn)

        btnsimpan.setOnClickListener {
            val cekjk = jenkel.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if (amcc.isChecked) {
                org.append("AMCC\n")
            }

            if (hmssi.isChecked){
                org.append("HMSSI\n")
            }

            if (bem.isChecked){
                org.append("BEM AMIKOM")
            }

            val bundle = Bundle()
            bundle.putString("nama", nama.text.toString())
            bundle.putString("nim", nim.text.toString())
            bundle.putString("email", email.text.toString())
            bundle.putString("hp", hp.text.toString())
            bundle.putString("jenkel", "${jk.text}")
            bundle.putString("prodi", spinner.selectedItem.toString())
            bundle.putString("org", org.toString())
            bundle.putString("status", togglebtn.text.toString())

            if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.error = "Masukkan email dengan benar"
            }
            else if (password.length()==0){
                password.error = "Password tidak boleh kosong"
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder( this)
                alertDialogBuilder.setTitle("Peringatan..!!")
                alertDialogBuilder.setMessage("Apakah data anda sudah benar..?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"
                    ) { dialogInterface, i ->
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this, "Data Profil Berhasil Tersimpan", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"
                    ) { dialogInterface, i -> dialogInterface.cancel()}
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }
    }
}