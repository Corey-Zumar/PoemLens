package com.poemlens.Activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.poemlens.Event.TagsReceivedEvent;
import com.poemlens.Fragment.PoemListFragment;
import com.poemlens.ImageRequestManager;
import com.poemlens.MediaManager;
import com.poemlens.Model.ImaggaTaggingResponse;
import com.poemlens.R;
import com.squareup.otto.Subscribe;


public class MainActivity extends BaseActivity {

    private static final int IMAGE_REQUEST_CODE = 377;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFragments();
    }

    public void initializeFragments() {
        PoemListFragment poemListFragment = new PoemListFragment();
        getFragmentManager().beginTransaction().replace(R.id.fl_fragment_container, poemListFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_new:
                captureImage();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private Uri fileUri;

    public void captureImage() {
        Intent imageCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = MediaManager.getOutputMediaFileUri(MediaManager.MEDIA_TYPE_IMAGE);
        imageCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(imageCaptureIntent, IMAGE_REQUEST_CODE);
    }

    private void handleImageResult() {
        if(fileUri == null) {
            return;
        }
        showLoadingDialog("Please Wait", "Analyzing image...");
        ImageRequestManager.makeImageRequest(fileUri);
    }

    @Subscribe
    public void OnTagsReceived(TagsReceivedEvent event) {
        dismissLoadingDialog();
        //Test output
        for(ImaggaTaggingResponse.Tag tag : event.tags) {
            Log.d(tag.getTag(), "" + tag.getConfidence());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case IMAGE_REQUEST_CODE:
                if(resultCode == RESULT_OK) {
                    handleImageResult();
                }
                break;
        }
    }
}
