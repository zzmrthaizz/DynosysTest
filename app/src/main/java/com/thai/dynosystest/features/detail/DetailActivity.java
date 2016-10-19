package com.thai.dynosystest.features.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thai.dynosystest.R;

public class DetailActivity extends AppCompatActivity {

    public static final String HERO_IMAGE = "heroImage";
    public static final String HERO_TYPE = "heroType";
    public static final String HERO_NAME = "heroName";
    public static final String HERO_STORY = "heroStory";

    private ImageView ivHero;
    private TextView tvStory;
    private TextView tvHeroName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivHero = (ImageView) findViewById(R.id.iv_hero_detail);
        tvStory = (TextView) findViewById(R.id.tv_story);
        tvHeroName = (TextView) findViewById(R.id.tv_hero_name);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ivHero.setImageResource(bundle.getInt(HERO_IMAGE));
            tvStory.setText(bundle.getString(HERO_STORY));
            tvHeroName.setText(bundle.getString(HERO_NAME));
        }

    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
        super.onBackPressed();
    }
}
