package com.gy.livedatmaster;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gy.livedatmaster.livedata.CustomData;
import com.gy.livedatmaster.livedata.CustomLiveData;

public class SecondActivity extends AppCompatActivity {

    TextView tv_second;
    CustomLiveData customLiveData;
    Button btn_secocnd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        customLiveData = CustomLiveData.instance(this);

        tv_second = findViewById(R.id.tv_second);
        btn_secocnd = findViewById(R.id.btn_secocnd);
        customLiveData.observe(this, new Observer<CustomData>() {
            @Override
            public void onChanged(@Nullable CustomData customData) {
                tv_second.setText(customData.getName());
            }
        });

        btn_secocnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomData customData = new CustomData();
                customData.setName("Second");
                customLiveData.setCustomVale(customData);
            }
        });
    }
}
