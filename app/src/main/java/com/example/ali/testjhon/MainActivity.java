package com.example.ali.testjhon;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ali.testjhon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Interface{

    private Presenter presenter;
    private ActivityMainBinding binding;
    private Property property;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        presenter = new Presenter(this, binding);
        property = new Property("");
        binding.setPresenter(presenter);
        binding.setProperty(property);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_on_off, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_off:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showColor(Integer color) {
        binding.imageIndikator.setBackgroundColor(ContextCompat.getColor(this, color));
    }

    @Override
    public void enableLamp(AppCompatImageView appCompatImageView) {
        appCompatImageView.setImageResource(R.drawable.transition_on);
        ((TransitionDrawable) appCompatImageView.getDrawable()).startTransition(3000);
    }

    @Override
    public void disableLamp(AppCompatImageView appCompatImageView) {
        appCompatImageView.setImageResource(R.drawable.transition_off);
        ((TransitionDrawable) appCompatImageView.getDrawable()).startTransition(300);
    }

    @Override
    public void setFirs(AppCompatImageView appCompatImageView) {
        appCompatImageView.setImageResource(R.drawable.transition_on);
    }
}
