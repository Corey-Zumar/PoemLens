package com.poemlens.Fragment;

/**
 * Created by Corey on 2/17/15.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.poemlens.R;

/**
 * Provides a list of previous poem-image matchings
 */
public class PoemListFragment extends BaseListFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_main, null);
        return initializeView(contentView);
    }

    @Override
    protected View initializeView(View contentView) {
        return contentView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeAdapter();
    }

    private void initializeAdapter() {

    }
}

