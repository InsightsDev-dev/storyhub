package io.storyhub.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Facebook '
 * @author chanwook
 */
public class FacebookGroupData implements Serializable {

    private List<FacebookGroup> data = new ArrayList<>();

    private FacebookPagination paging = new FacebookPagination();

    public List<FacebookGroup> getData() {
        return data;
    }

    public void setData(List<FacebookGroup> data) {
        this.data = data;
    }

    public FacebookPagination getPaging() {
        return paging;
    }

    public void setPaging(FacebookPagination paging) {
        this.paging = paging;
    }
}
