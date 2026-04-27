package de.traewelling.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import de.traewelling.app.data.model.Status

@Entity(tableName = "feed_statuses")
data class StatusEntity(
    @PrimaryKey val id: Int,
    val statusJson: String,
    val type: String // "dashboard" or "global"
)
