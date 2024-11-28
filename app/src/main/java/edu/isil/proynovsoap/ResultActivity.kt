package edu.isil.proynovsoap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.isil.provnovsoap.PlayerName
import edu.isil.provnovsoap.ResultAdapter

/**
 * Activity que muestra una lista de resultados en un RecyclerView.
 * Dependiendo del tipo de datos recibidos en el Intent, adapta la vista para mostrar
 * información de tarjetas, jugadores o jugadores con tarjetas.
 */
class ResultActivity : AppCompatActivity() {

    /**
     * Método llamado cuando la actividad se crea. Configura el RecyclerView y selecciona
     * el adaptador adecuado basado en el tipo de datos recibido.
     *
     * @param savedInstanceState Estado de la actividad guardado anteriormente.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Configuración inicial del RecyclerView con un LinearLayoutManager
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewResults)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtiene el tipo de datos que determina el contenido a mostrar en el RecyclerView
        val type = intent.getStringExtra("type")
        when (type) {
            "cards" -> {
                // Si el tipo es "cards", carga los datos como una lista de CardInfo
                val data = intent.getParcelableArrayListExtra<CardInfo>("data")
                if (data != null) {
                    val adapter = ResultAdapter(data) // Crea el adaptador para CardInfo
                    recyclerView.adapter = adapter
                }
            }
            "players" -> {
                // Si el tipo es "players", carga los datos como una lista de PlayerName
                val data = intent.getParcelableArrayListExtra<PlayerName>("data")
                if (data != null) {
                    val adapter = PlayerNameAdapter(data) // Crea el adaptador para PlayerName
                    recyclerView.adapter = adapter
               }
            }
            // "WithCards" -> {
            // Si el tipo es "WithCards", carga los datos como una lista de TeamPlayerCardInfo
            //    val data = intent.getParcelableArrayListExtra<TeamPlayerCardInfo>("data")
            //    if (data != null) {
            //        val adapter = ResultAllAdapter(data) // Crea el adaptador para TeamPlayerCardInfo
            //        recyclerView.adapter = adapter
            //    }
            //}
        }
    }
}