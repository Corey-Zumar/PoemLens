package com.poemlens;

import android.net.Uri;
import com.poemlens.Api.ImaggaApiInterface;
import com.poemlens.Event.TagsReceivedEvent;
import com.poemlens.Model.ImaggaTaggingResponse;
import com.poemlens.Model.ImaggaUploadResponse;

import java.io.File;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;

/**
 * Created by Corey on 2/19/15.
 */
public class ImageRequestManager {

    private static final String IMAGE_TYPE_JPEG = "image/jpg";

    public static void makeImageRequest(Uri fileUri) {
        if(fileUri == null) {
            return;
        }
        TypedFile file = new TypedFile(IMAGE_TYPE_JPEG, new File(fileUri.getPath()));

        ImaggaApiInterface.obtain().uploadImage(file, new Callback<ImaggaUploadResponse>() {

            @Override
            public void success(ImaggaUploadResponse imaggaUploadResponse, Response response) {
                if(imaggaUploadResponse.getUploaded() != null && imaggaUploadResponse.getUploaded().size() > 0) {
                    getTags(imaggaUploadResponse.getUploaded().get(0).getId());
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }

    private static void getTags(String contentId) {
        ImaggaApiInterface.obtain().getTags(contentId, new Callback<ImaggaTaggingResponse>(){

            @Override
            public void success(ImaggaTaggingResponse taggingResponse, Response response) {
                BusProvider.getBus().post(new TagsReceivedEvent(taggingResponse.getTags()));
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }


}
