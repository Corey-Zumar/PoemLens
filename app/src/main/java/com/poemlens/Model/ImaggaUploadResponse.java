package com.poemlens.Model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corey on 2/8/15.
 */
public class ImaggaUploadResponse {

    @Expose
    private String status;
    @Expose
    private List<Uploaded> uploaded = new ArrayList<Uploaded>();

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The uploaded
     */
    public List<Uploaded> getUploaded() {
        return uploaded;
    }

    /**
     *
     * @param uploaded
     * The uploaded
     */
    public void setUploaded(List<Uploaded> uploaded) {
        this.uploaded = uploaded;
    }

    public class Uploaded {

        @Expose
        private String filename;
        @Expose
        private String id;

        /**
         *
         * @return
         * The filename
         */
        public String getFilename() {
            return filename;
        }

        /**
         *
         * @param filename
         * The filename
         */
        public void setFilename(String filename) {
            this.filename = filename;
        }

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

    }

}