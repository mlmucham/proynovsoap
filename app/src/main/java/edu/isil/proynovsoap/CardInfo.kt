package edu.isil.proynovsoap

import android.os.Parcelable
import android.os.Parcel

data class CardInfo(
    val dDate: String?,
    val iMinute: Int,
    val sTeam1Name: String?,
    val sTeam2Name: String?,
    val sPlayerName: String?,
    val iRed: Int,
    val iYellow: Int

) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(dDate)
        parcel.writeInt(iMinute)
        parcel.writeString(sTeam1Name)
        parcel.writeString(sTeam2Name)
        parcel.writeString(sPlayerName)
        parcel.writeInt(iRed)
        parcel.writeInt(iYellow)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CardInfo>{

        override fun createFromParcel(parcel: Parcel): CardInfo {
            return CardInfo(parcel)
        }

        override fun newArray(size: Int): Array<CardInfo?> {
            return arrayOfNulls(size)
        }


    }

}
