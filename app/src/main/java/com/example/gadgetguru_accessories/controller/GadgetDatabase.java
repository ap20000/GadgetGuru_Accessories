package com.example.gadgetguru_accessories.controller;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.gadgetguru_accessories.model.User;

@Database(entities = {User.class}, version = 2)
public abstract class GadgetDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "gadgetguru";

    private static volatile GadgetDatabase INSTANCE;

    public static synchronized GadgetDatabase getInstance(Context context) {
//        Log.d("Database", "Creating database instance");
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GadgetDatabase.class, DATABASE_NAME)
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return INSTANCE;
    }

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // Migration strategy for upgrading from version 1 to version 2
            database.execSQL("ALTER TABLE user ADD COLUMN age INTEGER");
        }
    };

}
