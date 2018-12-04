package com.gy.livedatmaster.livedata.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

import com.gy.livedatmaster.MainActivity;
import com.gy.livedatmaster.ModelViewActivity;

public class ViewModelUntil {
    //viewModelProvider 需要单例 才能实现数据的统一 但是 没找到 可以单例的方法
    private static ViewModelProvider viewModelProvider;

    public static ViewModelProvider getViewModelProvider(Context context){
        if (context instanceof ModelViewActivity&&viewModelProvider==null){
            viewModelProvider = new ViewModelProvider((ModelViewActivity) context, new ViewModelProvider.Factory() {
                @NonNull
                @Override
                public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                    return (T) new CustomViewModel();
                }
            });
        }
        return viewModelProvider;
    }

}
