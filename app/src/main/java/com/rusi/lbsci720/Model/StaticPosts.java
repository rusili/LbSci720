package com.rusi.lbsci720.Model;

import android.util.Log;

public class StaticPosts {
	private static StaticPosts staticPosts;

	private StaticPosts(){}

	public static StaticPosts getStaticPosts(){
		if (staticPosts == null){
			staticPosts = new StaticPosts();
		}
		return staticPosts;
	}

	public void addRss (Rss rss) {
		Log.d("addRss: ", rss.getChannel().getItems().get(0).getTitle());
	}
}
