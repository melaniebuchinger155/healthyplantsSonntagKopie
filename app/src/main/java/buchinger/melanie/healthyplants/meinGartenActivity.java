package buchinger.melanie.healthyplants;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class meinGartenActivity extends AppCompatActivity {

    boolean pressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mein_garten);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) { //App beendet sich bei Doppelklick auf Zurückknopf, warnt zuvor mit einem Toast!

        if (keyCode == event.KEYCODE_BACK) {

            if (!pressedOnce) {
                pressedOnce = true;
                Toast.makeText(getApplicationContext(), "Erneut drücken, um zu beenden", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pressedOnce = false;
                    }
                }, 3000);
            } else if (pressedOnce) {
                pressedOnce =false;
                onBackPressed();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }






    @Override                                //Verhindert das zurückkehhren zur Startseite
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onButtonClick(View v) {
        Intent myIntent = new Intent(getBaseContext(), addplantsActivity.class);
        startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            case R.id.beschreibungid:
                startActivity(new Intent (this, BeschreibungActivitiy.class));
                return true;


            case R.id.hilfeid:
                startActivity(new Intent (this, HilfeActivity2.class));
                return true;

            case R.id.faqs:
                startActivity(new Intent (this, faqActivity.class));
                return true;


            case R.id.impressum:
                startActivity(new Intent (this, Impressum_activity.class));
                return true;


            case R.id.close:
                startActivity(new Intent (this, closeactivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);



        }
    }





}









