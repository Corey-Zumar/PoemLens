package com.poemlens.Api;

import android.util.Base64;

import com.poemlens.Model.ImaggaTaggingResponse;
import com.poemlens.Model.ImaggaUploadResponse;
import com.poemlens.Network.NetworkConfig;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

/**
 * Created by Corey on 2/7/15.
 */
public class ImaggaApiInterface {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String AUTHORIZATION_PARAMETERS = new StringBuilder()
            .append("Basic ")
            .append(Base64.encodeToString(String.format("%s:%s", NetworkConfig.IMAGGA_API_KEY,
                    NetworkConfig.IMAGGA_API_SECRET).getBytes(), Base64.NO_WRAP))
            .toString();

    private static final RestAdapter ADAPTER =
            new RestAdapter.Builder()
            .setEndpoint(NetworkConfig.IMAGGA_API_ENDPOINT)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    request.addHeader(AUTHORIZATION_HEADER, AUTHORIZATION_PARAMETERS);
                }
            })
            .build();

    private static final ImaggaApi IMAGGA_API = ADAPTER.create(ImaggaApi.class);


    public static ImaggaApi obtain() {
        return IMAGGA_API;
    }


    public interface ImaggaApi {

        @Multipart
        @POST("/content")
        public void uploadImage(@Part("File") TypedFile file, Callback<ImaggaUploadResponse> callback);

        @GET("/tagging")
        public void getTags(@Query("content") String contentId, Callback<ImaggaTaggingResponse> callback);

        @GET("/usage")
        public void getUsage(Callback<Object> callback);

    }



}
