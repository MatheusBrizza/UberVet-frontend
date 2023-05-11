package br.com.fundatec.ubervet_frontend.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.ubervet_frontend.databinding.ListItemBinding
import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse

class ListItemAdapter : RecyclerView.Adapter<ListItemViewHolder>() {

    private val list = mutableListOf<VeterinarioResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItems(veterinarios: List<VeterinarioResponse>) {
        list.clear()
        list.addAll(veterinarios)
        notifyDataSetChanged()
    }
}