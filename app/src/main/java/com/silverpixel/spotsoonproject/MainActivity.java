package com.silverpixel.spotsoonproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SliderLayout mDemoSlider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication ob= new MyApplication();
        Thread.setDefaultUncaughtExceptionHandler(ob.uncaughtExceptionHandler);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Chainsmokers 1",R.drawable.cs);
        file_maps.put("Chainsmokers 2",R.drawable.cs2);
        file_maps.put("Chainsmokers 3",R.drawable.cs3);
        file_maps.put("Chainsmokers 4", R.drawable.cs4);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.ZoomIn);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
        mDemoSlider.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        toolbar = (Toolbar) findViewById(R.id.toolbar);



        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);

                TextView tmp=(TextView)tab.getCustomView().findViewById(R.id.tab);
                tmp.setTextColor(Color.parseColor("#ff5220"));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                super.onTabUnselected(tab);
                TextView tmp=(TextView)tab.getCustomView().findViewById(R.id.tab);
                tmp.setTextColor(Color.parseColor("#ababab"));

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();


    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VideosFragment(), "VIDEOS");
        adapter.addFragment(new ImagesFragment(), "IMAGES");
        adapter.addFragment(new MilestoneFragment(), "MILESTONE");
        adapter.addFragment(new NaviMilestoneFragment(), "NAVI-MILESTONE");
        adapter.addFragment(new VRVideosFragment(), "VR-VIDEOS");
        adapter.addFragment(new AboutusFragment(), "ABOUT-US");
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {
        String[] title={"VIDEOS","IMAGES","MILESTONE","NAVI-MILESTONE","VR-VIDEOS","ABOUT-US"};
        int[] icons={R.drawable.videosiconselector,R.drawable.imagesiconselector,R.drawable.milestoniconselector,R.drawable.naviiconselector,R.drawable.vrvideoiconselector,R.drawable.aboutusiconselector};
        for(int i=0;i<title.length;i++){
            View tab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            TextView t1=(TextView)tab.findViewById(R.id.tab);
            t1.setText(title[i]);
            tab.findViewById(R.id.icon).setBackgroundResource(icons[i]);
            tabLayout.getTabAt(i).setCustomView(tab);
        }


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
    /*@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }*/

}
