package exosphere.alexandra.riceonabudget;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.Toast;

import exosphere.alexandra.riceonabudget.model.Ratings;


public class Paella extends ActionBarActivity {
    private static float paellaRating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paella);
        Ratings.RATINGS.readFile(this);
        RatingBar ratingBarpaella = (RatingBar) findViewById(R.id.ratingBarpaella);
        ratingBarpaella.setRating(Ratings.RATINGS.paellaRating);
        ratingBarpaella.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               Ratings.RATINGS.paellaRating = rating;
                Ratings.RATINGS.saveFile(Paella.this);
                Toast.makeText(Paella.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_paella, menu);
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
}
