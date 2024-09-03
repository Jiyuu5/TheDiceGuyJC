package de.rockbiter.thediceguy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Preset::class], version = 1)
abstract class TDGDatabase: RoomDatabase() {

    abstract fun getPresetDao() : PresetDao

    companion object {

        @Volatile
        private var DATABASE_INSTANCE: TDGDatabase? = null

        fun getDatabase(context: Context): TDGDatabase {

            return DATABASE_INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    TDGDatabase::class.java,
                    "tdc-database"
                ).build()
                DATABASE_INSTANCE = instance
                instance
            }
        }
    }
}