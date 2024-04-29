package com.managerofthings.sqllite.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bullshit")
data class Bullshit (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image") val image: ByteArray,
    @ColumnInfo(name = "time") val time: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bullshit

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (!image.contentEquals(other.image)) return false
        if (time != other.time) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + image.contentHashCode()
        result = 31 * result + (time?.hashCode() ?: 0)
        return result
    }
}