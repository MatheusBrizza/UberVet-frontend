package br.com.fundatec.ubervet_frontend.home.presentation


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse
import br.com.fundatec.ubervet_frontend.profile.domain.VeterinarioUsecase
import kotlinx.coroutines.launch

class HomeFragmentViewModel: ViewModel() {
    private val state = MutableLiveData<ViewState>()
    val viewState : LiveData<ViewState> = state

    private val useCase: VeterinarioUsecase by lazy {
        VeterinarioUsecase()
    }

    fun preencherRecyclerView() {
        viewModelScope.launch {
            val veterinariosList: List<VeterinarioResponse> = useCase.listarTodosVeterinarios()
            Log.e("CharacterDataSource", "characterList: " + "${veterinariosList}")
            if (veterinariosList.isEmpty()) {
                state.value = ViewState.MostrarListaVazia
            } else {
                state.value = ViewState.MostrarVeterinariosList(veterinariosList)
            }
        }
    }

}

sealed class ViewState {
    data class MostrarVeterinariosList(val veterinariosList: List<VeterinarioResponse>) : ViewState()
    object MostrarListaVazia : ViewState()
}