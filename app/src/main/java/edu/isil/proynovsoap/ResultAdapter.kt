package edu.isil.provnovsoap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.isil.proynovsoap.CardInfo
import edu.isil.proynovsoap.R

/**
 * Adaptador para el RecyclerView que muestra una lista de objetos CardInfo,
 * con información detallada sobre las tarjetas de los jugadores en un partido.
 *
 * @param results Lista de objetos CardInfo que contienen los datos de cada tarjeta.
 */
class ResultAdapter(private val results: List<CardInfo>) :
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {

    /**
     * Clase ViewHolder que representa cada elemento en la lista.
     * Contiene referencias a los TextViews que muestran los datos de cada tarjeta.
     *
     * @param view La vista del elemento que será asociada al ViewHolder.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewDate: TextView = view.findViewById(R.id.textViewDate)
        val textViewMinute: TextView = view.findViewById(R.id.textViewMinute)
        val textViewTeams: TextView = view.findViewById(R.id.textViewTeams)
        val textViewPlayer: TextView = view.findViewById(R.id.textViewPlayer)
        val textViewCards: TextView = view.findViewById(R.id.textViewCards)
    }

    /**
     * Infla el layout del elemento individual de la lista y crea un ViewHolder con él.
     *
     * @param parent ViewGroup en el cual la nueva vista se añadirá después de ser inflada.
     * @param viewType Tipo de la vista (en este caso solo hay un tipo de vista).
     * @return Un nuevo ViewHolder que contiene la vista inflada.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result, parent, false)
        return ViewHolder(view)
    }

    /**
     * Asigna los datos de un objeto CardInfo a los elementos del ViewHolder.
     *
     * @param holder ViewHolder que debe ser actualizado para mostrar los datos del elemento actual.
     * @param position Posición del elemento actual en la lista.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.textViewDate.text = "Date: ${result.dDate}"
        holder.textViewMinute.text = "Minute: ${result.iMinute}"
        holder.textViewTeams.text = "Team1: ${result.sTeam1Name}, Team2: ${result.sTeam2Name}"
        holder.textViewPlayer.text = "Player: ${result.sPlayerName}"
        holder.textViewCards.text = "Red Cards: ${result.iRed}, Yellow Cards: ${result.iYellow}"
    }

    /**
     * Devuelve el tamaño de la lista de resultados.
     *
     * @return Cantidad de elementos en la lista de resultados.
     */
    override fun getItemCount() = results.size
}
