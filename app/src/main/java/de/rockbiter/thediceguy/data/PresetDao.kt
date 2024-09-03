package de.rockbiter.thediceguy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PresetDao {
    @Query("SELECT * FROM Preset WHERE setId = (:presetId)")
    fun getAllByPresetId(presetId: Int): List<Preset>

    @Insert
    fun insertPreset(preset: Preset)

    @Delete
    fun deletePreset(preset: Preset)

    @Delete
    fun deletePresetTable(table: DeleteTable)
}