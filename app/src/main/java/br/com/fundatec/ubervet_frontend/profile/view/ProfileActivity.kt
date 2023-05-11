package br.com.fundatec.ubervet_frontend.profile.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.ubervet_frontend.databinding.ActivityProfileBinding
import br.com.fundatec.ubervet_frontend.profile.presentation.ProfileViewModel

class ProfileActivity: AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val viewmodel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configNovoVeterinarioButton()
    }

    private fun configNovoVeterinarioButton() {
        binding.btnProfile.setOnClickListener {
            viewmodel.criarVeterinario(
                id = binding.etId.text.toString(),
                nome = binding.etName.text.toString(),
                registro =  binding.etRegistro.text.toString(),
                especializacao = binding.etEspecializacao.text.toString(),
                endereco = binding.etEndereco.text.toString(),
                telefone = binding.etTelefone.text.toString(),
                email = binding.etEmail.text.toString(),
                senha = binding.etSenha.text.toString()
            )
            retornarHome()
        }
    }

    private fun retornarHome() {
        finish()
    }
}