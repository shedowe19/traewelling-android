package de.traewelling.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StatusDao {

    @Query("SELECT * FROM feed_statuses WHERE type = :type ORDER BY id DESC")
    suspend fun getStatuses(type: String): List<StatusEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStatuses(statuses: List<StatusEntity>)

    @Query("DELETE FROM feed_statuses WHERE type = :type")
    suspend fun clearStatuses(type: String)
}
