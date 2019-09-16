package com.bymdev.pass2sdk.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bymdev.pass2sdk.room.dao.AccountDao
import com.bymdev.pass2sdk.room.entity.AccountEntity


@Database(entities = [AccountEntity::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    /**
     * We use fallbackToDestructiveMigration
     * to clear database every time when
     * version has been upgraded
     */
//    TODO remove fallbackToDestructiveMigration and provide migration scheme before release
    companion object {
        private val DB_NAME = "pass_sdk_database.db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                    return INSTANCE!!
                }
            } else {
                return INSTANCE!!
            }
        }
    }

    abstract fun accountDao(): AccountDao
}