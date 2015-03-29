package exosphere.alexandra.riceonabudget.model;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Alexandra on 3/28/2015.
 */
public class Ratings implements Serializable {
    public static Ratings RATINGS = new Ratings();
    public float tunaRiceRating;
    public float pumpkinRating;
    public float chickenRating;
    public float beefRating;
    public float chickenasRating;
    public float curryRating;
    public float geelrysRating;
    public float paellaRating;




    public void readFile(Context context) {
            String filename = "myfile";
            FileInputStream inputStream;
            String textFromFile = "";
            try {
                inputStream = context.openFileInput(filename);
                ObjectInputStream ois = new ObjectInputStream(inputStream);
                RATINGS = (Ratings) ois.readObject();
                inputStream.close();
            } catch (Exception e) {
                Log.e("Experiment", e.getMessage());
                e.printStackTrace();
            }
    }
    public void saveFile(Context context) {
            String filename = "myfile";
            FileOutputStream outputStream;

            try {
                outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeObject(this);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }


}
