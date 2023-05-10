package br.com.fundatec.ubervet_frontend.profile.domain

import br.com.fundatec.ubervet_frontend.login.data.remote.RemoteLoginDataSource
import br.com.fundatec.ubervet_frontend.profile.data.local.Veterinario

class VeterinarioUsecase {
    private val remoteLoginDataSource: RemoteLoginDataSource by lazy {
        RemoteLoginDataSource()
    }

    suspend fun login(email: String, senha: String) : Boolean{
        return remoteLoginDataSource.login(veterinario = Veterinario(email, senha))
    }

}