package br.com.fundatec.ubervet_frontend.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.fundatec.ubervet_frontend.databinding.FragmentHomeBinding
import br.com.fundatec.ubervet_frontend.home.presentation.HomeFragmentViewModel
import br.com.fundatec.ubervet_frontend.home.presentation.ViewState
import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val adapter by lazy {
        ListItemAdapter()
    }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(HomeFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        viewModel.viewState.observe(viewLifecycleOwner) { state ->
            when(state) {
                is ViewState.MostrarListaVazia -> recyclerVazio()
                is ViewState.MostrarVeterinariosList -> adicionarItens(state.veterinariosList)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        init()
    }

    private fun init() {
        viewModel.preencherRecyclerView()
    }

    private fun adicionarItens(veterinariosList: List<VeterinarioResponse>) {
        adapter.setItems(veterinariosList)
    }

    private fun recyclerVazio() {
        Toast.makeText(requireContext(), "Recycler está vazio.", Toast.LENGTH_LONG).show()
    }
}