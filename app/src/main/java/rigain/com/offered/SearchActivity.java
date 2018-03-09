package rigain.com.offered;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.net.Uri;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import rigain.com.offered.fragments.AccountFragment;
import rigain.com.offered.fragments.PostFragment;
import rigain.com.offered.fragments.SearchFragment;
import rigain.com.offered.fragments.WatchListFragment;
import rigain.com.offered.util.SectionsPagerAdapter;


public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

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

        setupViewPager();

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

}
