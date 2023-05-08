package br.com.fundatec.ubervet_frontend.home.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.fundatec.ubervet_frontend.databinding.FragmentHomeBinding
import br.com.fundatec.ubervet_frontend.home.view.ListItemAdapter

class CharacterFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val adapter by lazy {
        ListItemAdapter()
    }
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get()
    }
}