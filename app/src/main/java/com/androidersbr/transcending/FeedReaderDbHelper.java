package com.androidersbr.transcending;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gumiero on 09/08/2015 at 22:45 for Transcending.
 * This is a database helper class
 */
public class FeedReaderDbHelper extends SQLiteOpenHelper {
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
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
