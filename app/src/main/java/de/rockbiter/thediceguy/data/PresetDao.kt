package de.rockbiter.thediceguy.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PresetDao {
    @Query("SELECT * FROM Preset")
    fun getAllByPresetId(): List<Preset>

    @Insert
    fun insertPreset(preset: Preset)

    @Delete
    fun deletePreset(preset: Preset)

    @Query("DELETE FROM Preset")
    fun deleteAllPresets()
}