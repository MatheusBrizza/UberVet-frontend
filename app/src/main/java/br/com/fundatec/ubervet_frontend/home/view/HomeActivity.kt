package br.com.fundatec.ubervet_frontend.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.ubervet_frontend.R
import br.com.fundatec.ubervet_frontend.databinding.ActivityHomeBinding
import br.com.fundatec.ubervet_frontend.profile.view.ProfileActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configNovoVeterinarioButton()

    }

    private fun configNovoVeterinarioButton() {
        binding.btnNovoVeterinario.setOnClickListener {
            startActivity(Intent(this@HomeActivity, ProfileActivity::class.java))
        }
    }
}