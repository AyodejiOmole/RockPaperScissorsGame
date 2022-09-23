package com.example.rockpaperscissors.View;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rockpaperscissors.R;
import com.google.android.material.tabs.TabLayout;

public class AboutFragment extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;

    public AboutFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        viewPagerAdapter = new ViewPagerAdapter(requireActivity().getSupportFragmentManager());
        viewPagerAdapter.add(new AboutGame(), "About the Game");
        viewPagerAdapter.add(new AboutDeveloper(), "About the Developer");

        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}