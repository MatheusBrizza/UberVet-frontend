package br.com.fundatec.ubervet_frontend.profile.data.remote

import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface VeterinarioApi {

    @GET("api/v1/veterinarios")
    suspend fun listarTodosVeterinarios(): Response<List<VeterinarioResponse>>

    @POST("api/v1/veterinarios/profile")
    suspend fun create(
        @Body veterinarioRequest: VeterinarioRequest
    ): Response<VeterinarioResponse?>

    @DELETE("api/v1/veterinarios/{veterinarioId}")
    suspend fun delete(
        @Path("veterinarioId") veterinarioId: String,
        @Body veterinario: VeterinarioRequest
    ): Response<String?>
}