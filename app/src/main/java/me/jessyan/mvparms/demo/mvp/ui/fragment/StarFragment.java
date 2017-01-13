package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.jessyan.mvparms.demo.R;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class StarFragment extends Fragment{

    private ViewPager mVpContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_star, null);

        mVpContainer = (ViewPager) view.findViewById(R.id.vp_container);
        mVpContainer.setAdapter(new MyAdapter(getChildFragmentManager()));


        return view;
    }
}
