package edu.isil.proynovsoap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.isil.provnovsoap.PlayerName

/**
 * Adaptador para mostrar una lista de objetos PlayerName en un RecyclerView.
 *
 * @property players Lista de objetos PlayerName que se mostrarán.
 */
class PlayerNameAdapter(private val players: List<PlayerName>) :
    RecyclerView.Adapter<PlayerNameAdapter.ViewHolder>() {

    /**
     * ViewHolder interno para mantener las referencias a las vistas de cada elemento de la lista.
     *
     * @param view Vista de un elemento en el RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.textViewId)
        val textViewName: TextView = view.findViewById(R.id.textViewName)
        val textViewCountryName: TextView = view.findViewById(R.id.textViewCountryName)
        val imageViewCountryFlag: ImageView = view.findViewById(R.id.imageViewCountryFlag)
    }

    /**
     * Inflates el layout de cada elemento en el RecyclerView.
     *
     * @param parent El ViewGroup padre que contiene las vistas.
     * @param viewType Tipo de vista que representa el nuevo elemento de la lista.
     * @return Instancia de ViewHolder inicializada con la vista inflada.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player_name, parent, false)
        return ViewHolder(view)
    }

    /**
     * Enlaza los datos de un PlayerName con las vistas en el ViewHolder.
     *
     * @param holder ViewHolder que contiene las vistas a actualizar.
     * @param position Posición del elemento en la lista de datos.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]
        holder.textViewId.text = "ID: ${player.iId}"
        holder.textViewName.text = "Name: ${player.sName}"
        holder.textViewCountryName.text = "Country: ${player.sCountryName}"

        // Carga de la imagen de la bandera del país usando Glide
        Glide.with(holder.itemView.context)
            .load(player.sCountryFlag)
            .into(holder.imageViewCountryFlag)
    }

    /**
     * Devuelve el tamaño de la lista de jugadores.
     *
     * @return Número de elementos en la lista players.
     */
    override fun getItemCount() = players.size
}