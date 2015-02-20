package com.poemlens.Api;

import com.poemlens.Network.NetworkConfig;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Corey on 2/8/15.
 */
public class CloudSightApiInterface {

    private static final RestAdapter ADAPTER =
            new RestAdapter.Builder()
                    .setEndpoint(NetworkConfig.CLOUD_SIGHT_API_ENDPOINT)
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestFacade request) {
                            request.addHeader("Authorization", "CloudSight 1jD3HLz7PsqMyHlH95qZcg");
                        }
                    })
                    .build();

    private static final CloudSightApi CLOUD_SIGHT_API = ADAPTER.create(CloudSightApi.class);

    public static CloudSightApi obtain() {
        return CLOUD_SIGHT_API;
    }

    public interface CloudSightApi {

        @Multipart
        @POST("/image_requests")
        public void uploadImage(@Part("image") TypedFile image, @Part("locale") String locale, Callback<Object> callback);

    }


}
