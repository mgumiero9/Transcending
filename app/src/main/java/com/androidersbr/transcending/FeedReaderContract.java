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
        public static final String DOCUMENT_NAME = "document_name";
        public static final String PARAGRAPH_NUMBER = "paragraph_number";
        public static final String PARAGRAPH_CONTENT = "paragraph_content";
        public static final String PARAGRAPH_TYPE = "paragraph_type";
    }
}