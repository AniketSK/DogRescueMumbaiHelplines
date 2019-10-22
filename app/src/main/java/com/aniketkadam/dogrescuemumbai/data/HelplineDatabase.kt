package com.aniketkadam.dogrescuemumbai.data

import android.content.Context
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Chetan on 2019-10-19.
 */

private const val DATABASE_NAME = "animal_helpline_db"

@Database(
    entities = [AnimalHelpLine::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CustomTypeConverter::class)
abstract class HelplineDatabase : RoomDatabase() {

    abstract fun helpLineDao(): AnimalHelplLineDao

    companion object {
        private var INSTANCE: HelplineDatabase? = null

        fun getInstance(context: Context): HelplineDatabase? {
            if (INSTANCE == null) {
                synchronized(HelplineDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        HelplineDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}

private class CustomTypeConverter {

    @TypeConverter
    fun stringToList(string: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun listToString(list: List<String>): String {
        return Gson().toJson(list)
    }
}