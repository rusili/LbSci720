package com.rusi.lbsci720.Model;

import android.util.Log;

import com.rusi.lbsci720.Activity.Main.MainInterface;

import java.util.List;

public class StaticPosts {
	private static Rss staticRss = new Rss();
	private static MainInterface.Presenter mainPresenter;

	public StaticPosts(MainInterface.Presenter mainPresenter){
		this.mainPresenter = mainPresenter;
	}

	public static void addRss (Rss rss) {
		Log.d("addRss: ", rss.getChannel().getItems().get(0).getTitle());
		staticRss = rss;
		mainPresenter.updateAdvancedRecyclerView();
	}

	public static Channel getChannel(){
		return staticRss.getChannel();
	}

	public static  List<Item> getItems(){
		return staticRss.getChannel().getItems();
	}
}
