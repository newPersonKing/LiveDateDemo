package com.gy.livedatmaster;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
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

public class ModelViewActivity extends AppCompatActivity {


    TextView tv_model_view;
    Button btn_model_view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_model_view);

        tv_model_view = findViewById(R.id.tv_model_view);
        btn_model_view = findViewById(R.id.btn_model_view);

        ViewModelProvider viewModelProvider= ViewModelUntil.getViewModelProvider(this);

        CustomViewModel customViewModel = viewModelProvider.get(CustomViewModel.class);
        customViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tv_model_view.setText(s);
            }
        });

        btn_model_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  =  new Intent(ModelViewActivity.this,ModelViewSecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
