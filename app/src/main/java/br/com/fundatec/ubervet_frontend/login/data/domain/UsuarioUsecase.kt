package br.com.fundatec.ubervet_frontend.login.data.domain

import br.com.fundatec.ubervet_frontend.login.data.local.Usuario
import br.com.fundatec.ubervet_frontend.login.data.remote.RemoteLoginDataSource

class UsuarioUsecase {

    private val remoteLoginDataSource: RemoteLoginDataSource by lazy {
        RemoteLoginDataSource()
    }

    suspend fun login(email: String, senha: String) : Boolean {
        return remoteLoginDataSource.login(usuario = Usuario(email, senha))
    }
}