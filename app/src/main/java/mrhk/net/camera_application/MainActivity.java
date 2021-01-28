package mrhk.net.camera_application;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final int CAMERA_REQUEST = 1888;
    private ImageView iv_camera;
    private Button btn_capture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_camera = (ImageView)findViewById(R.id.iv_camera);
        btn_capture = (Button) findViewById(R.id.btn_capture);

        //On button click
        btn_capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent  to camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAMERA_REQUEST){
            Bitmap photo =(Bitmap)data.getExtras().get("data");
            iv_camera.setImageBitmap(photo);
        }
        //else{
          //  super.onActivityResult(requestCode,resultCode,data);
        //}

    }

}