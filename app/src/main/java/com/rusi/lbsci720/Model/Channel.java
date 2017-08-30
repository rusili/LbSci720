package com.rusi.lbsci720.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "channel", strict = false)
public class Channel {

    @ElementList(name = "item", inline = true)
    public List<Item> mItems;

    @Element(required = false)
    private String pubDate;
    @Element(required = false)
    private String title;
    @Element(required = false)
    private String managingEditor;
    @Element(required = false)
    private String description;
    @Element(required = false)
    private String docs;
    @Element(required = false)
    private String link;
    @Element(required = false)
    private String lastBuildDate;
    @Element(required = false)
    private String generator;
    @Element(required = false)
    private String language;
    @Element(required = false)
    private String webMaster;

    public List<Item> getItems(){
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems = items;
    }
}
