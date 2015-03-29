package exosphere.alexandra.riceonabudget;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.Toast;

import exosphere.alexandra.riceonabudget.model.Ratings;


public class Geelrys extends ActionBarActivity {
    private static float geelrysRating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geelrys);
        Ratings.RATINGS.readFile(this);
        RatingBar ratingBargeelrys = (RatingBar) findViewById(R.id.ratingBargeelrys);
        ratingBargeelrys.setRating(Ratings.RATINGS.geelrysRating);
        ratingBargeelrys.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Ratings.RATINGS.geelrysRating = rating;
                Ratings.RATINGS.saveFile(Geelrys.this);
                Toast.makeText(Geelrys.this, String.valueOf(rating), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geelrys, menu);
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
