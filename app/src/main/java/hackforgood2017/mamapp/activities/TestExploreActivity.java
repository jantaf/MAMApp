package hackforgood2017.mamapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dd.CircularProgressButton;

import hackforgood2017.mamapp.R;

public class TestExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_explore);
        final CircularProgressButton circularButton1 = (CircularProgressButton) findViewById(R.id.btnCircular);
        circularButton1.setIndeterminateProgressMode(true);
        circularButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (circularButton1.getProgress() == 0) {
                    circularButton1.setProgress(50);
                    new CountDownTimer(2000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onFinish() {
                            // TODO Auto-generated method stub

                            circularButton1.setProgress(100);
                            new CountDownTimer(1000, 1000) {

                                @Override
                                public void onTick(long millisUntilFinished) {
                                    // TODO Auto-generated method stub

                                }

                                @Override
                                public void onFinish() {
                                    // TODO Auto-generated method stub
                                    startActivity(new Intent(TestExploreActivity.this,ResultsActivity.class));
                                    finish();
                                }
                            }.start();
                        }
                    }.start();
                } else if (circularButton1.getProgress() == 100) {


                } else {
                    circularButton1.setProgress(100);
                }
            }
        });
    }
}
