package io.storyhub.group;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chanwook
 */
public class FacebookPagination implements Serializable {

    private Map<String, String> cursors = new HashMap<>();

    private String previous;

    private String next;

    public Map<String, String> getCursors() {
        return cursors;
    }

    public void setCursors(Map<String, String> cursors) {
        this.cursors = cursors;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
