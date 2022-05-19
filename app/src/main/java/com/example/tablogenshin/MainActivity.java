package com.example.tablogenshin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer venty = 0;
    private Integer xily = 0;
    private TextView ventyTextView;
    private TextView xilyTextView;

    private static final String TAG = "MainActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ventyTextView = findViewById(R.id.venty_score);
        xilyTextView = findViewById(R.id.xily_score);
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddVenty(View view) {
        venty++;
        ventyTextView.setText(venty.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickAddXily(View view) {
        xily++;
        xilyTextView.setText(xily.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickButtonClear(View view) {
        venty = 0;
        xily = 0;

        resetUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("venty", venty);
        outState.putInt("xily", xily);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("venty")) {
            venty= savedInstanceState.getInt("venty");
        }
        if ((savedInstanceState != null && savedInstanceState.containsKey("xily"))) {
            xily= savedInstanceState.getInt("xily");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @SuppressLint("SetTextI18n")
    private void resetUI() {
        ventyTextView.setText(venty.toString());
        xilyTextView.setText(xily.toString());
        Log.d(TAG, "resetUI");
    }
}