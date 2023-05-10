package br.com.fundatec.ubervet_frontend.profile.data.response

data class VeterinarioResponse(
    val id: String,
    val nome: String,
    val registro: String,
    val especializacao: String,
    val endereco: String,
    val telefone: String,
    val email: String,
    val senha: String
)