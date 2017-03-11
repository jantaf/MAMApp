package hackforgood2017.mamapp.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hackforgood2017.mamapp.R;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        if(getIntent().getExtras()!=null) {
            Bundle extras = getIntent().getExtras();
            byte[] byteArray = extras.getByteArray("picture");

            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            //ImageView image = (ImageView) findViewById(R.id.photo);

            //image.setImageBitmap(bmp);
        }
    }
}
