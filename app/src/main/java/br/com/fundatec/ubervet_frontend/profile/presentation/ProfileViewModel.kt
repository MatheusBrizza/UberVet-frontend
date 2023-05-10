package br.com.fundatec.ubervet_frontend.profile.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.ubervet_frontend.profile.domain.VeterinarioUsecase
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val usecase: VeterinarioUsecase by lazy {
        VeterinarioUsecase()
    }

    fun criarVeterinario(id: String, nome: String, registro: String, especializacao: String, endereco: String,
                         telefone: String,email: String, senha: String) {
        viewModelScope.launch {
            val veterinarioCriado = usecase.salvarVeterinario(id, nome, registro, especializacao,
                endereco, telefone,email, senha)
            if (veterinarioCriado != null) {
                state.value = ViewState.ShowSuccess
            } else {
                state.value = ViewState.ShowError
            }


        }
    }

}

sealed class ViewState {
    object ShowSuccess : ViewState()
    object ShowError : ViewState()
}