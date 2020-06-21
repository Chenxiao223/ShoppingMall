package com.example.shoppingmall.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.shoppingmall.R;
import com.example.shoppingmall.fragment.ClassiFicationFragment;
import com.example.shoppingmall.fragment.HomePageFragment;
import com.example.shoppingmall.fragment.MeFragment;
import com.example.shoppingmall.fragment.ShoppingCartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    BottomNavigationView bottom_ngs;
    private int index = 0;
    private String fragmentTag;
    private ArrayList<String> fragmentNames;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        bottom_ngs = findViewById(R.id.bottom_ngs);
        fragmentNames = new ArrayList<>();
        fragmentNames.add(HomePageFragment.class.getName());
        fragmentNames.add(ClassiFicationFragment.class.getName());
        fragmentNames.add(ShoppingCartFragment.class.getName());
        fragmentNames.add(MeFragment.class.getName());

        fragmentTag = fragmentNames.get(index);
        Fragment fragment = getFragmentByTag(fragmentTag);
        showFragment(mCurrentFragment, fragment, fragmentTag);

        initListener();
    }

    private void initListener() {
        bottom_ngs.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.homeFragment) {
                    index = 0;
                } else if (menuItem.getItemId() == R.id.classiFication) {
                    index = 1;
                } else if (menuItem.getItemId() == R.id.shoppingCart) {
                    index = 2;
                } else if (menuItem.getItemId() == R.id.me) {
                    index = 3;
                }
                fragmentTag = fragmentNames.get(index);
                Fragment fragment = getFragmentByTag(fragmentTag);
                showFragment(mCurrentFragment, fragment, fragmentTag);

                return true;
            }
        });
    }

    private Fragment getFragmentByTag(String name) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment != null) {
            return fragment;
        } else {
            try {
                fragment = (Fragment) Class.forName(name).newInstance();
            } catch (Exception e) {
                // fragment = new HomeFragment();
            }
        }
        return fragment;
    }

    private void showFragment(Fragment from, Fragment to, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (from == null) {
            if (to.isAdded()) {
                transaction.show(to);
            } else {
                transaction.add(R.id.fragment_nrs, to, tag);
            }
        } else {
            if (to.isAdded()) {
                transaction.hide(from).show(to);
            } else {
                transaction.hide(from).add(R.id.fragment_nrs, to, tag);
            }
        }
        transaction.commitAllowingStateLoss();
        mCurrentFragment = to;
    }
}
