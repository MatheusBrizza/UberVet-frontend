package br.com.fundatec.ubervet_frontend.login.data.remote

import android.util.Log
import br.com.fundatec.ubervet_frontend.profile.data.local.Veterinario
import br.com.fundatec.ubervet_frontend.webservice.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteLoginDataSource {
    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(LoginApi::class.java)

    suspend fun login(veterinario: Veterinario): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val loginSuccess = service.login(veterinario = veterinario)
                if (loginSuccess.isSuccessful) {
                    loginSuccess.body()
                } else {
                    false
                }
            } catch (ex: Exception) {
                Log.e("LoginProblem", ex.message ?: "Login não realizado")
                false
            }!!
        }
    }
}