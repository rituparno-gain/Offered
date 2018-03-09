package rigain.com.offered.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rigain.com.offered.R;

/**
 * Created by rigain on 3/9/2018.
 */

public class WatchListFragment extends Fragment {

    private static final String TAG = "WatchListFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_watch_list, container, false);
        return view;
    }
}
