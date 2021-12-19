package com.ashwin.android.imageviewscaletype;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MatrixActivity extends AppCompatActivity {
    private static final String SUB_TAG = MatrixActivity.class.getSimpleName();

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        imageView = findViewById(R.id.matrix_image_view);

        RadioGroup radioGroup = findViewById(R.id.matrix_radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateImage(checkedId);
            }
        });
    }

    private void updateImage(@IdRes int matrixTypeId) {
        if (matrixTypeId == R.id.none_radio_button) {
            Log.d(MainActivity.APP_TAG, SUB_TAG + ": none");
            imageView.setImageMatrix(new Matrix());
        }
        else if (matrixTypeId == R.id.translate_radio_button) {
            Log.d(MainActivity.APP_TAG, SUB_TAG + ": translate");
            Matrix matrix = new Matrix();
            matrix.setTranslate(50f, 50f);
            imageView.setImageMatrix(matrix);
        }
        else if (matrixTypeId == R.id.rotate_radio_button) {
            Log.d(MainActivity.APP_TAG, SUB_TAG + ": rotate");
            Matrix matrix = new Matrix();
            matrix.setRotate(15f);  // Sets rotation to the given value
//            matrix.postRotate(15f);  // Adds the given rotation to the existing matrix
            imageView.setImageMatrix(matrix);
        }
        else if (matrixTypeId == R.id.scale_radio_button) {
            Log.d(MainActivity.APP_TAG, SUB_TAG + ": scale");
            Matrix matrix = new Matrix();
            matrix.setScale(2f, 1.5f);  // 2*width, 1.5*heigth
            imageView.setImageMatrix(matrix);
        }
        else if (matrixTypeId == R.id.skew_radio_button) {
            Log.d(MainActivity.APP_TAG, SUB_TAG + ": skew");
            Matrix matrix = new Matrix();
//            matrix.setSkew(20f, 1f);  // Shifts x base to right
//            matrix.setSkew(-20f, 1f);  // Shifts x top to left
//            matrix.setSkew(1f, 20f);  // Shifts y right down
            matrix.setSkew(1f, -20f);  // Shifts y left up
            imageView.setImageMatrix(matrix);
        }
    }
}
