package edu.isil.provnovsoap

import android.os.Parcel
import android.os.Parcelable

/**
 * Clase de datos PlayerName
 * Representa la información básica de un jugador, incluyendo su ID, nombre, país de origen y la bandera de su país.
 * Implementa Parcelable para facilitar la transferencia de instancias entre componentes de Android.
 *
 * @property iId Identificador único del jugador.
 * @property sName Nombre del jugador.
 * @property sCountryName Nombre del país de origen del jugador.
 * @property sCountryFlag URL o referencia a la bandera del país del jugador.
 */
data class PlayerName(
    val iId: Int,
    val sName: String,
    val sCountryName: String,
    val sCountryFlag: String
) : Parcelable {

    /**
     * Constructor secundario que crea una instancia de PlayerName a partir de un Parcel.
     * Este constructor es utilizado por el sistema Android para deserializar el objeto.
     *
     * @param parcel Parcel que contiene los datos serializados para reconstruir la instancia.
     */
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    /**
     * Escribe los datos de la instancia actual de PlayerName en un Parcel, para que puedan ser
     * transferidos entre componentes de Android.
     *
     * @param parcel Parcel donde se escriben los datos.
     * @param flags Indicadores adicionales sobre cómo escribir el objeto.
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(iId)
        parcel.writeString(sName)
        parcel.writeString(sCountryName)
        parcel.writeString(sCountryFlag)
    }

    /**
     * Describe el tipo de contenido de los objetos Parcelable. Aquí devuelve 0.
     */
    override fun describeContents(): Int {
        return 0
    }

    /**
     * Objeto companion que implementa el Parcelable.Creator para PlayerName, permitiendo que el sistema
     * Android cree nuevas instancias de PlayerName a partir de un Parcel.
     */
    companion object CREATOR : Parcelable.Creator<PlayerName> {
        /**
         * Crea una instancia de PlayerName a partir de un Parcel.
         *
         * @param parcel Parcel que contiene los datos serializados.
         * @return Nueva instancia de PlayerName.
         */
        override fun createFromParcel(parcel: Parcel): PlayerName {
            return PlayerName(parcel)
        }

        /**
         * Crea un array de PlayerName de tamaño especificado.
         *
         * @param size Tamaño del array.
         * @return Array de PlayerName de tamaño dado.
         */
        override fun newArray(size: Int): Array<PlayerName?> {
            return arrayOfNulls(size)
        }
    }
}
