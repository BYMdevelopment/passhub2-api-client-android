package com.bymdev.pass2sdk.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bymdev.pass2sdk.room.dao.AccountDao
import com.bymdev.pass2sdk.room.entity.AccountEntity


@Database(entities = [AccountEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DB_NAME = "pass_sdk_database.db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, DB_NAME).build()
                    return INSTANCE!!
                }
            } else {
                return INSTANCE!!
            }
        }
    }

    abstract fun accountDao(): AccountDao
}