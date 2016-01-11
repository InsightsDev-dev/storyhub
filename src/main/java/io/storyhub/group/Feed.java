package io.storyhub.group;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chanwook
 */
public class Feed implements Serializable {

    @JsonProperty(value = "data")
    private List<Post> postList = new ArrayList<>();

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
