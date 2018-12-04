package com.gy.livedatmaster;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gy.livedatmaster.livedata.viewmodel.CustomViewModel;
import com.gy.livedatmaster.livedata.viewmodel.ViewModelUntil;

public class ModelViewSecondActivity extends AppCompatActivity {

    Button btn_model_view_second;
    TextView tv_model_view_second;
    private CustomViewModel customViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_view_second);

        btn_model_view_second = findViewById(R.id.btn_model_view_second);
        tv_model_view_second = findViewById(R.id.tv_model_view_second);

        ViewModelProvider viewModelProvider = ViewModelUntil.getViewModelProvider(this);

        customViewModel = viewModelProvider.get(CustomViewModel.class);

        customViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_model_view_second.setText(s);
            }
        });

        btn_model_view_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customViewModel.getCurrentName().setValue("ModelViewSecondActivity");
            }
        });
    }
}
