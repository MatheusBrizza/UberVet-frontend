package br.com.fundatec.ubervet_frontend.login.data.remote

import br.com.fundatec.ubervet_frontend.profile.data.local.Veterinario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("api/v1/veterinarios/login")
    suspend fun login(
        @Body veterinario: Veterinario
    ): Response<Boolean>


}