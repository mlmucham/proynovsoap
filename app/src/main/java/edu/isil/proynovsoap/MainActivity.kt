package edu.isil.proynovsoap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * MainActivity es la actividad principal de la aplicación que permite al usuario
 * realizar varias acciones, como obtener información de todas las tarjetas o nombres de jugadores.
 * Implementa funciones para manejar las llamadas a la API utilizando Retrofit y muestra los resultados en ResultActivity.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Método onCreate inicializa los componentes de la interfaz y define los listeners para
     * los botones que inician las solicitudes a la API para obtener la información deseada.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia a los botones de la UI
        val buttonFetchAllCards = findViewById<Button>(R.id.buttonFetchAllCards)
        val buttonFetchAllPlayers = findViewById<Button>(R.id.buttonFetchAllPlayers)

        // Asignación de funciones a los botones
        buttonFetchAllCards.setOnClickListener {
            fetchAllCardsInfo()
        }

        buttonFetchAllPlayers.setOnClickListener {
            fetchAllPlayerNames()
        }



    }

    /**
     * fetchAllCardsInfo realiza una solicitud en segundo plano para obtener la información de
     * todas las tarjetas mediante Retrofit. Si la solicitud es exitosa, abre ResultActivity para
     * mostrar los datos. En caso de error, muestra un mensaje en el registro y un Toast al usuario.
     */
    private fun fetchAllCardsInfo() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = RetrofitClient.instance.getAllCardsInfo()
                withContext(Dispatchers.Main) {
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putParcelableArrayListExtra("data", ArrayList(result))
                    intent.putExtra("type", "cards")
                    startActivity(intent)
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching all cards info", e)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error fetching all cards info", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun fetchAllPlayerNames() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result = RetrofitClient.instance.getAllPlayerNames()
                withContext(Dispatchers.Main) {
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putParcelableArrayListExtra("data", ArrayList(result))
                    intent.putExtra("type", "players")
                    startActivity(intent)
                }
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching all player names", e)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Error fetching all player names", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}