package br.com.fundatec.ubervet_frontend.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.ubervet_frontend.profile.domain.VeterinarioUsecase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = state

    private val usecase: VeterinarioUsecase by lazy {
        VeterinarioUsecase()
    }

    fun loginUsuario(email: String, senha: String) {
        viewModelScope.launch {
                val loginSuccess = usecase.login(email, senha)
            if(loginSuccess == true){

            state.value = ViewState.ShowSuccess
            }else
                state.value = ViewState.ShowError
        }
    }


}

sealed class ViewState {
    object ShowSuccess : ViewState()
    object ShowError : ViewState()
}