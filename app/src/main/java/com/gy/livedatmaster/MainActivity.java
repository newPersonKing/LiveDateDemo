package com.gy.livedatmaster;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gy.livedatmaster.livedata.CustomData;
import com.gy.livedatmaster.livedata.CustomLiveData;

public class MainActivity extends AppCompatActivity {

    private TextView tv_main;
    private Button btn_main;

    private CustomLiveData customLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customLiveData = CustomLiveData.instance(this);

        tv_main = findViewById(R.id.tv_main);
        btn_main = findViewById(R.id.btn_main);

        customLiveData.observe(this, new Observer<CustomData>() {
            @Override
            public void onChanged(@Nullable CustomData customData) {
                tv_main.setText(customData.getName());
            }
        });

        CustomData customData = new CustomData();
        customData.setName("MainActivity");
        customLiveData.setCustomVale(customData);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
