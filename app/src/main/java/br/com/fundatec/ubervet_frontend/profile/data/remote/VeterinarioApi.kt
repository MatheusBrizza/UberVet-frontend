package br.com.fundatec.ubervet_frontend.profile.data.remote

import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface VeterinarioApi {

    @POST("api/v1/veterinarios/profile")
    suspend fun create(
        @Body veterinarioRequest: VeterinarioRequest
    ): Response<VeterinarioResponse?>
}