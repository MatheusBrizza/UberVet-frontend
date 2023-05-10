package br.com.fundatec.ubervet_frontend.profile.domain

import br.com.fundatec.ubervet_frontend.login.data.remote.RemoteLoginDataSource
import br.com.fundatec.ubervet_frontend.profile.data.local.Veterinario
import br.com.fundatec.ubervet_frontend.profile.data.remote.RemoteVeterinarioDataSource
import br.com.fundatec.ubervet_frontend.profile.data.remote.VeterinarioRequest

class VeterinarioUsecase {
    private val remoteLoginDataSource: RemoteLoginDataSource by lazy {
        RemoteLoginDataSource()
    }
    private val remoteVeterinarioDataSource: RemoteVeterinarioDataSource by lazy {
        RemoteVeterinarioDataSource()
    }

    suspend fun login(email: String, senha: String) : Boolean{
        return remoteLoginDataSource.login(veterinario = Veterinario(email, senha))
    }

    suspend fun salvarVeterinario(id: String, nome: String, registro: String, especializacao: String,
                                  endereco: String, telefone: String, email: String, senha: String) {
        remoteVeterinarioDataSource.criarVeterinario(veterinarioRequest = VeterinarioRequest(id, nome,
            registro, especializacao, endereco, telefone,email, senha))
    }

}