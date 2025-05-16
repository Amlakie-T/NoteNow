package com.notenow.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notenow.app.core.constant.DatabaseConst
import com.notenow.app.data.local.dao.NoteDao
import com.notenow.app.domain.model.Note

@Database(
    entities = [Note::class],
    version = DatabaseConst.NOTES_DATABASE_VERSION,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}