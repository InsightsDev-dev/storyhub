package io.storyhub.facebook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chanwook
 */
public class GroupList implements Serializable {

    private List<Group> data = new ArrayList<>();

    private FacebookPagination paging = new FacebookPagination();

    public List<Group> getData() {
        return data;
    }

    public void setData(List<Group> data) {
        this.data = data;
    }

    public FacebookPagination getPaging() {
        return paging;
    }

    public void setPaging(FacebookPagination paging) {
        this.paging = paging;
    }
}
