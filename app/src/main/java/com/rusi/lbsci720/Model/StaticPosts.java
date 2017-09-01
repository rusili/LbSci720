package com.rusi.lbsci720.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class StaticPosts {
	private static StaticPosts staticPosts;
	private Channel channel;
	private List<Item> itemList = new ArrayList <>();

	private StaticPosts(){
		itemList.add(new Item("title", "description", "pubDate", "link", "guid"));
	}

	public static StaticPosts getStaticPosts(){
		if (staticPosts == null){
			staticPosts = new StaticPosts();
		}
		return staticPosts;
	}

	public void addRss (Rss rss) {
		Log.d("addRss: ", rss.getChannel().getItems().get(0).getTitle());
		RssParser(rss);
	}

	private void RssParser (Rss rss) {
		this.channel = rss.getChannel();
		this.itemList = rss.getChannel().getItems();
	}

	public Channel getChannel(){
		return  this.channel;
	}

	public List<Item> getItemList(){
		return this.itemList;
	}
}
