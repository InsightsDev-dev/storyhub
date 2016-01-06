package io.storyhub.group;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * mapping to https://developers.facebook.com/docs/graph-api/reference/v2.5/group
 *
 * @author chanwook
 */
public class FacebookGroup implements Serializable {

    private String id;

    private String name;

    private String privacy;

    private String description;

    private String email;

    private String icon;

    private String link;

    @JsonProperty(value = "updated_time")
    private LocalDateTime updatedTime;

    @JsonProperty(value = "member_request_count")
    private String memberRequestCount;

    //TODO cover, owner, parent

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMemberRequestCount() {
        return memberRequestCount;
    }

    public void setMemberRequestCount(String memberRequestCount) {
        this.memberRequestCount = memberRequestCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
