package com.androidersbr.transcending;

/**
 * Created by Gumiero on 25/08/2015 at 00:46 for Transcending.
 */

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;

public class ExternalDBActivity extends Activity {
    /** Called when the activity is first created. */
    DBHelper dbhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] from = new String[] { "_id", "paragraph_content" };
        int[] to = new int[] { R.id.TextView1, R.id.TextView2 };

        dbhelper = new DBHelper(this);

        try {
            dbhelper.createDataBase();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Cursor c = dbhelper.getData();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(), R.layout.list, c, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        ListView list = (ListView) findViewById(R.id.ListView1);

        list.setAdapter(adapter);
    }
}
