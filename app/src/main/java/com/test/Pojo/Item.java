package com.test.Pojo;

/**
 * Created by Ayhan on 15.01.2017.
 */
import org.simpleframework.xml.*;
@Root(name="item",strict=false)
public class Item {
    @Element(name="title")
    private String title;
    @Element(name="link")
    private String link;
    @Element(name="description")
    private String description;
    @Element(name="pubDate")
    private String pubDate;
    @Element(name="guid")
    private String guid;
    @Element(name="creator")
    @Namespace(prefix="dc")
    private String creator;
    @Element(name="date")
    @Namespace(prefix="dc")
    private String date;

    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getLink() {
        return link;
    }
    public String getDate() {
        return date;
    }
    public String getDescription() {
        return description;
    }
    public String getGuid() {
        return guid;
    }
    public String getPubDate() {
        return pubDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}