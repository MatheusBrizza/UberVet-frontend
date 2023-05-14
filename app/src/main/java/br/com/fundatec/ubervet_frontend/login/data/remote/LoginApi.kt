package br.com.fundatec.ubervet_frontend.login.data.remote

import br.com.fundatec.ubervet_frontend.login.data.local.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("api/v1/usuarios/login")
    suspend fun login(
        @Body usuario : Usuario
    ): Response<Boolean>
}