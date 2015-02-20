package com.poemlens.Fragment;

import android.app.ListFragment;
import android.view.View;

import com.poemlens.BusProvider;

/**
 * Created by Corey on 2/17/15.
 */
public abstract class BaseListFragment extends ListFragment {

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getBus().unregister(this);
    }

    protected abstract View initializeView(View contentView);
}
