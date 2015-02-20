package com.poemlens.Event;

import com.poemlens.Model.ImaggaTaggingResponse;

import java.util.List;

/**
 * Created by Corey on 2/19/15.
 */
public class TagsReceivedEvent {

    public List<ImaggaTaggingResponse.Tag> tags;

    public TagsReceivedEvent(List<ImaggaTaggingResponse.Tag> tags) {
        this.tags = tags;
    }


}
