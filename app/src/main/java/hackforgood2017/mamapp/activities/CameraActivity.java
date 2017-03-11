package hackforgood2017.mamapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.flurgle.camerakit.CameraListener;
import com.flurgle.camerakit.CameraView;

import cn.pedant.SweetAlert.SweetAlertDialog;
import hackforgood2017.mamapp.R;

import static hackforgood2017.mamapp.R.id.camera;

public class CameraActivity extends AppCompatActivity {
    CameraView cameraView;
    ImageView btnPhoto;
    byte[] photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        cameraView=(CameraView)findViewById(camera);
        btnPhoto=(ImageView)findViewById(R.id.btn_photo);
        cameraView.setCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] picture) {
                super.onPictureTaken(picture);
                photo=picture;
                initAlertFinish();
                // Create a bitmap



            }
        });
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraView.captureImage();
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    protected void onPause() {
        cameraView.stop();
        super.onPause();
    }
    @Override
    protected  void onStop(){
        super.onStop();
    }
    private void initAlertFinish() {
        final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        pDialog.setTitleText("Analizando...");
        pDialog.setCancelable(false);
        pDialog.show();
        new CountDownTimer(3000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                // TODO Auto-generated method stub
                Intent intent=new Intent(CameraActivity.this,ResultsActivity.class);
                //intent.putExtra("picture", photo);
                startActivity(intent);

                finish();
                pDialog.dismiss();
            }
        }.start();
    }
}
