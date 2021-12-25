package com.wave.livedataexample.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolderWeather extends RecyclerView.ViewHolder{
    private int mCurrentPosition;
    public BaseViewHolderWeather(@NonNull View itemView) {
        super(itemView);
    }
    protected abstract void clear();

    public void onBind(int position) {
        mCurrentPosition = position;
        clear();
    }

    public int getCurrentPosition() {
        return mCurrentPosition;
    }


}
