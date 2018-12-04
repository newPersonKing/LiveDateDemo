package com.gy.livedatmaster.livedata;

import android.arch.lifecycle.LiveData;
import android.content.Context;

public class CustomLiveData extends LiveData<CustomData> {

    private static CustomLiveData customLiveData;

    private CustomLiveData(Context context){ }

    public static CustomLiveData instance(Context context){
        if (customLiveData==null){
            customLiveData = new CustomLiveData(context);
        }
        return customLiveData;
    }

    @Override
    protected void onActive() {
        super.onActive();
    }


    @Override
    protected void onInactive() {
        super.onInactive();
    }


    @Override
    protected void setValue(CustomData value) {
        super.setValue(value);
    }

    public void setCustomVale(CustomData vale){
        setValue(vale);
    }
}
