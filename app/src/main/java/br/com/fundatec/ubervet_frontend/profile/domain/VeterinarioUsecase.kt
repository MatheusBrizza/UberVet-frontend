package br.com.fundatec.ubervet_frontend.profile.domain

import br.com.fundatec.ubervet_frontend.profile.data.remote.RemoteVeterinarioDataSource
import br.com.fundatec.ubervet_frontend.profile.data.remote.VeterinarioRequest
import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse

class VeterinarioUsecase {

    private val remoteVeterinarioDataSource: RemoteVeterinarioDataSource by lazy {
        RemoteVeterinarioDataSource()
    }

    suspend fun listarTodosVeterinarios(): List<VeterinarioResponse> {
        return remoteVeterinarioDataSource.listarTodosVeterinarios()
    }

    suspend fun salvarVeterinario(nome: String, registro: String, especializacao: String,
                                  endereco: String, telefone: String, email: String, senha: String) {
        remoteVeterinarioDataSource.criarVeterinario(veterinarioRequest = VeterinarioRequest(nome,
            registro, especializacao, endereco, telefone,email, senha))
    }

}