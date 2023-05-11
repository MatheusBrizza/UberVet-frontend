package br.com.fundatec.ubervet_frontend.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.ubervet_frontend.databinding.ListItemBinding
import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse

class ListItemViewHolder (
    private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(veterinario: VeterinarioResponse) {
            binding.tvName.text = veterinario.nome
            binding.tvEspecializacao.text = veterinario.especializacao
            binding.tvEndereco.text = veterinario.endereco
            binding.tvTelefone.text = veterinario.telefone
        }
    }