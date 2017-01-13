package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.jessyan.mvparms.demo.R;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class MyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("MyFragment", "onCreateView");
        View view = inflater.inflate(R.layout.frag_my, container, false);
        return view;
    }
}
