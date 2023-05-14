package br.com.fundatec.ubervet_frontend.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.ubervet_frontend.databinding.ActivityHomeBinding
import br.com.fundatec.ubervet_frontend.login.view.LoginActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configLoginButton()

    }

    private fun configLoginButton() {
        binding.btnNovoVeterinario.setOnClickListener {
            startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
        }
    }
}