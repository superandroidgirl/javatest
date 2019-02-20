package javatest.iristai.com.javatest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import javatest.iristai.com.javatest.locationlist.LocationListFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolbar(toolbar);

    }

    private void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();

//        mToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(mDrawer.isDrawerOpen(GravityCompat.START)){
//                    mDrawer.closeDrawer(GravityCompat.START);
//                }else {
//                    mDrawer.openDrawer(GravityCompat.START);
//                }
//
//            }
//        });
        initFragment();
    }

    private void initFragment() {
        replaceFragment(LocationListFragment.newInstance(), "LocationListFragment", false, false);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            getCurrentFragment().onResume();
        }
    }

    /**
     * 替換FragmentLayout中的Fragment
     *
     * @param fragment         ftagment實體
     * @param fragmentName     fragment名稱 用以辨別
     * @param isAdd            fragment是用add方式還是replace方式 true:add, false:replace
     * @param isAddToBackStack 是否要將前一個fragment塞入BackStack  true:塞入, false:不塞入
     */
    public void replaceFragment(Fragment fragment, String fragmentName, boolean isAdd, boolean isAddToBackStack) {
        int layoutID = R.id.fragment_layout;
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if (isAdd) {
                fragmentTransaction.add(layoutID, fragment, fragmentName);
            } else {
                fragmentTransaction.replace(layoutID, fragment, fragmentName);
            }

            if (isAddToBackStack)
                fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setBurger(Boolean show) {
        final ActionBar actionBar = getSupportActionBar();
        if (show) {
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(false);
                mToggle.setDrawerIndicatorEnabled(true);
                mToggle.syncState();
            }
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mDrawer.isDrawerOpen(GravityCompat.START)){
                        mDrawer.closeDrawer(GravityCompat.START);
                    }else {
                        mDrawer.openDrawer(GravityCompat.START);
                    }
                }
            });
        } else {
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeButtonEnabled(true);

            }

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        onBackPressed();
                }
            });
        }
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_layout);
    }
}

