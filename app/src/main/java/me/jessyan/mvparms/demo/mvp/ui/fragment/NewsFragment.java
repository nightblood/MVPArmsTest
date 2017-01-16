package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import common.AppComponent;
import common.WEFragment;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.presenter.NullPresenter;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class NewsFragment extends WEFragment<NullPresenter> implements OnTabSelectListener {

    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout mSlidingTabLayout;
    @BindView(R.id.vp_container)
    ViewPager mVpContainer;

    private List<Class> mFragments = new ArrayList<>();
    private final String[] mTitles = {"标签1", "标签2", "标签3", "标签4"};

    @Override
    protected void ComponentInject() {

    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }

    @Override
    protected View initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.frag_news, null);
        return view;
    }

    @Override
    protected void initData() {
        mFragments.add(MyFragment.class);
        NewsPageAdapter adapter = new NewsPageAdapter(getChildFragmentManager());
        mVpContainer.setAdapter(adapter);

        mSlidingTabLayout.setViewPager(mVpContainer);
        mSlidingTabLayout.setOnTabSelectListener(this);
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }

    class NewsPageAdapter extends FragmentStatePagerAdapter {

        public NewsPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = Fragment.instantiate(getContext(), mFragments.get(position).getName());
            return fragment;
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
