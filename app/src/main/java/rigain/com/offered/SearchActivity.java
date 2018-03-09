package rigain.com.offered;

import android.*;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rigain.com.offered.fragments.AccountFragment;
import rigain.com.offered.fragments.PostFragment;
import rigain.com.offered.fragments.SearchFragment;
import rigain.com.offered.fragments.WatchListFragment;
import rigain.com.offered.util.SectionsPagerAdapter;


public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";
    private static final int REQUEST_PERMISSIONS_CODE = 11111;

    //Widgets
    private TabLayout mTabLayout;
    public ViewPager mViewPager;

    //variables
    public SectionsPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_container);

        verifyPermissions();

    }

    private void setupViewPager(){

        mPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new SearchFragment());
        mPagerAdapter.addFragment(new WatchListFragment());
        mPagerAdapter.addFragment(new PostFragment());
        mPagerAdapter.addFragment(new AccountFragment());

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(getString(R.string.fragment_search));
        mTabLayout.getTabAt(1).setText(getString(R.string.fragment_watchlist));
        mTabLayout.getTabAt(2).setText(getString(R.string.fragment_post));
        mTabLayout.getTabAt(3).setText(getString(R.string.fragment_account));

    }

    private void verifyPermissions(){
        Log.d(TAG, "verifyPermissions: asking user for permissions");
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.CAMERA,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[0]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this.getApplicationContext(),
                        permissions[1]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this.getApplicationContext(),
                        permissions[2]) == PackageManager.PERMISSION_GRANTED){
                setupViewPager();
        } else {
            ActivityCompat.requestPermissions(SearchActivity.this,
                    permissions,
                    REQUEST_PERMISSIONS_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }
}
