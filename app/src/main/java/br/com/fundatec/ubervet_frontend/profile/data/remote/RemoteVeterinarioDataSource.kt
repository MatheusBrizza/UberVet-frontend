package br.com.fundatec.ubervet_frontend.profile.data.remote

import android.util.Log
import br.com.fundatec.ubervet_frontend.login.data.remote.LoginApi
import br.com.fundatec.ubervet_frontend.profile.data.response.VeterinarioResponse
import br.com.fundatec.ubervet_frontend.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteVeterinarioDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(VeterinarioApi::class.java)

    suspend fun criarVeterinario(veterinarioRequest: VeterinarioRequest): VeterinarioResponse? {
        return withContext(Dispatchers.IO) {
            try{
                val veterinarioCriado = service.create(veterinarioRequest = veterinarioRequest)
                if (veterinarioCriado.isSuccessful) {
                    veterinarioCriado.body()
                } else {
                    null
                }
            } catch (ex: Exception) {
                Log.e("VeterinarioProblem", ex.message ?: "falha ao criar veterinario")
                null
            }
        }
    }
}