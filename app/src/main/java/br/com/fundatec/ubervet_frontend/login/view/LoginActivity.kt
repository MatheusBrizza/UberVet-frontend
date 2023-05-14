package br.com.fundatec.ubervet_frontend.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.ubervet_frontend.databinding.ActivityLoginBinding
import br.com.fundatec.ubervet_frontend.login.presentation.LoginViewModel
import br.com.fundatec.ubervet_frontend.login.presentation.ViewState
import br.com.fundatec.ubervet_frontend.profile.view.ProfileActivity

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is ViewState.ShowSuccess -> ShowSucess()
                is ViewState.ShowError -> showError()
            }
        }
        configLoginButton()
    }

    private fun configLoginButton() {
        binding.btnLogin.setOnClickListener {
            viewModel.loginUsuario(
                email = binding.etEmail.text.toString(),
                senha = binding.etSenha.text.toString()
            )
        }
    }

    private fun ShowSucess() {
        startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
    }

    private fun showError() {
        Toast.makeText(this, "login incompleto", Toast.LENGTH_LONG).show()
    }
}