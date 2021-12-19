package com.ashwin.android.imageviewscaletype;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String APP_TAG = "image-scale";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.scale_types_radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateImage(checkedId);
            }
        });

        hideAllImageViews();
    }

    private void updateImage(@IdRes int scaleTypeId) {
        hideAllImageViews();
        int imageViewId = getImageViewId(scaleTypeId);
        if (imageViewId != 0) {
            showImageView(imageViewId);
        } else {
            Log.e("image-view-scale-type", "updateImage: ImageView Id not found!");
        }
    }

    private int getImageViewId(@IdRes int radioButtonId) {
        if (radioButtonId == R.id.center_radio_button) {
            return R.id.center_image_view;
        }
        if (radioButtonId == R.id.center_crop_radio_button) {
            return R.id.center_crop_image_view;
        }
        if (radioButtonId == R.id.center_inside_radio_button) {
            return R.id.center_inside_image_view;
        }
        if (radioButtonId == R.id.fit_center_radio_button) {
            return R.id.fit_center_image_view;
        }
        if (radioButtonId == R.id.fit_start_radio_button) {
            return R.id.fit_start_image_view;
        }
        if (radioButtonId == R.id.fit_end_radio_button) {
            return R.id.fit_end_image_view;
        }
        if (radioButtonId == R.id.fit_xy_radio_button) {
            return R.id.fit_xy_image_view;
        }
        return 0;
    }

    private void hideAllImageViews() {
        findViewById(R.id.center_image_view).setVisibility(View.GONE);
        findViewById(R.id.center_crop_image_view).setVisibility(View.GONE);
        findViewById(R.id.center_inside_image_view).setVisibility(View.GONE);
        findViewById(R.id.fit_center_image_view).setVisibility(View.GONE);
        findViewById(R.id.fit_start_image_view).setVisibility(View.GONE);
        findViewById(R.id.fit_end_image_view).setVisibility(View.GONE);
        findViewById(R.id.fit_xy_image_view).setVisibility(View.GONE);
    }

    private void showImageView(@IdRes int id) {
        ImageView imageView = findViewById(id);
        imageView.setVisibility(View.VISIBLE);
    }
}
