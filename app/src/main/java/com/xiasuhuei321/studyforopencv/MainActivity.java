package com.xiasuhuei321.studyforopencv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_img;
    private ImageView iv_result_img;
    private Button bt_blur;
    private Button bt_gray;
    private OpenCVHelper openCVHelper;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        openCVHelper = new OpenCVHelper();
    }

    private void initView() {
        iv_img = (ImageView) findViewById(R.id.iv_img);
        iv_result_img = (ImageView) findViewById(R.id.iv_result_img);

        bt_blur = (Button) findViewById(R.id.bt_blur);
        bt_gray = (Button) findViewById(R.id.bt_gray);
        bt_blur.setOnClickListener(this);
        bt_gray.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_blur:
                Bitmap blur = openCVHelper.blur(getBitmap());
                iv_result_img.setImageBitmap(blur);
                break;
            case R.id.bt_gray:
                Bitmap gray = getBitmap();
                Bitmap result = openCVHelper.gray(gray);
                iv_result_img.setImageBitmap(result);
                break;
        }
    }

    private Bitmap getBitmap() {
        if (bitmap == null) {
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ssm);
        }
        return bitmap;
    }
}
