package com.androidersbr.transcending;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gumiero on 09/08/2015 at 22:45 for Transcending.
 * This is a database helper class
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.FeedEntry.DOCUMENT_NAME + " (" +
                    FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedEntry.PARAGRAPH_NUMBER + TEXT_TYPE + COMMA_SEP +
                    FeedReaderContract.FeedEntry.PARAGRAPH_CONTENT + TEXT_TYPE + COMMA_SEP +
                    FeedReaderContract.FeedEntry.PARAGRAPH_TYPE + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.DOCUMENT_NAME;


    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Transcending10.db3";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<String> getData() {
        db = this.getReadableDatabase();
        List<String> data = new ArrayList<String>();
        Cursor c = db.rawQuery("SELECT paragraph_content FROM documents3", null);
        while (c.moveToNext()) {
            data.add(c.getString(1));
        }
        c.close();
        db.close();
        return data;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
