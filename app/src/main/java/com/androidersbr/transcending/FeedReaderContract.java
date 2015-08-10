package com.androidersbr.transcending;

import android.provider.BaseColumns;

/**
 * Created by Gumiero on 09/08/2015 at 22:26 for Transcending.
 * This will be the database contract
 */
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "document";
        public static final String COLUMN_NAME_DOCUMENT_ID = "documentid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_PARAGRAPH_NUMBER = "paragraphnumber";
        public static final String COLUMN_NAME_PARAGRAPH_CONTENT = "paragraphcontent";
    }
}