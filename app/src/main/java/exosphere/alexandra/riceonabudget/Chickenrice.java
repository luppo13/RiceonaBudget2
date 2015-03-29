package exosphere.alexandra.riceonabudget;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.Toast;

import exosphere.alexandra.riceonabudget.model.Ratings;


public class Chickenrice extends ActionBarActivity {

    private static float chickenRating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chickenrice);
        Ratings.RATINGS.readFile(this);
        RatingBar ratingBarchicken = (RatingBar) findViewById(R.id.ratingBarchicken);
        ratingBarchicken.setRating(Ratings.RATINGS.chickenRating);
        ratingBarchicken.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               Ratings.RATINGS.chickenRating = rating;
               Ratings.RATINGS.saveFile(Chickenrice.this);
                Toast.makeText(Chickenrice.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chickenrice, menu);
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
