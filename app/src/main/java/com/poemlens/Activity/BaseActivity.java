package com.poemlens.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;

import com.poemlens.BusProvider;

/**
 * Created by Corey on 2/7/15.
 */
public class BaseActivity extends ActionBarActivity {

    private static ProgressDialog dialog;

    @Override
    protected void onStart() {
        super.onStart();
        BusProvider.getBus().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.getBus().unregister(this);
    }

    protected void showLoadingDialog(String title, String message) {
        dialog = new ProgressDialog(this);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.show();
    }

    protected void dismissLoadingDialog() {
        if(dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }



}
