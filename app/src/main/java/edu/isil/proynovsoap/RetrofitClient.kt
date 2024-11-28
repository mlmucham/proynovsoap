package edu.isil.proynovsoap


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Objeto Singleton que configura y proporciona una instancia de Retrofit para interactuar
 * con el servicio web especificado.
 *
 * Este objeto utiliza el patrón Singleton con la ayuda de `by lazy` para asegurarse de que
 * la instancia de `Retrofit` se crea solo una vez cuando es necesaria.
 */
object RetrofitClient {

    // URL base del servicio web que se utilizará para las solicitudes
    private const val BASE_URL = "https://ws.footballpool.dataaccess.eu/"

    /**
     * Instancia de ApiService que proporciona acceso a los métodos de API definidos.
     *
     * El bloque `by lazy` asegura que esta instancia se crea la primera vez que se accede,
     * lo que permite una configuración de inicialización perezosa.
     */
    val instance: ApiService by lazy {
        // Construcción de la instancia Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)  // Establece la URL base para las solicitudes
            .addConverterFactory(GsonConverterFactory.create())  // Conversor de JSON a objetos
            .build()

        // Crea la implementación de la interfaz ApiService
        retrofit.create(ApiService::class.java)
    }
}