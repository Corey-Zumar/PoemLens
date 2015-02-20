package com.poemlens.Model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Corey on 2/19/15.
 */
public class ImaggaTaggingResponse {

    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     *
     * @return
     * The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Tag> getTags() {
        if(results != null && results.size() > 0) {
            return results.get(0).getTags();
        }
        return null;
    }

    public class Result {

        @Expose
        private String image;
        @Expose
        private List<Tag> tags = new ArrayList<Tag>();

        /**
         *
         * @return
         * The image
         */
        public String getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(String image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The tags
         */
        public List<Tag> getTags() {
            return tags;
        }

        /**
         *
         * @param tags
         * The tags
         */
        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

    }

    public class Tag {

        @Expose
        private Double confidence;
        @Expose
        private String tag;

        /**
         *
         * @return
         * The confidence
         */
        public Double getConfidence() {
            return confidence;
        }

        /**
         *
         * @param confidence
         * The confidence
         */
        public void setConfidence(Double confidence) {
            this.confidence = confidence;
        }

        /**
         *
         * @return
         * The tag
         */
        public String getTag() {
            return tag;
        }

        /**
         *
         * @param tag
         * The tag
         */
        public void setTag(String tag) {
            this.tag = tag;
        }

    }

}