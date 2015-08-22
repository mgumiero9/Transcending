package com.androidersbr.transcending;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EntranceScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance_screen);
        ShowHideSystemUI.hideSystemUI(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        ShowHideSystemUI.hideSystemUI(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entrance_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginApp(View view) {
        Intent newIntent = new Intent(this, MainActivity.class);
        startActivity(newIntent);
    }

    public void facebookLoginApp(View view) {
        Intent newIntent = new Intent(this, ListViewLoader.class);
        startActivity(newIntent);
    }
}
