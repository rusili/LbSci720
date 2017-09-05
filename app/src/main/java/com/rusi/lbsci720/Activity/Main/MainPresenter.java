package com.rusi.lbsci720.Activity.Main;

import android.support.v7.widget.RecyclerView;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.FeedAdapter;
import com.rusi.lbsci720.Model.StaticPosts;
import com.rusi.lbsci720.Network.RXRetrofit;

public class MainPresenter implements MainInterface.Presenter{
	private MainInterface.View mainInterfaceView;
	private FeedAdapter feedAdapter;

	public MainPresenter(){
		feedAdapter = new FeedAdapter();
	}

	public void setAdvancedRecyclerviewAdapter(RecyclerView recyclerViewFeed, RecyclerViewExpandableItemManager recyclerViewExpandableItemManager){
		feedAdapter.setItemList(StaticPosts.getItems());
		recyclerViewFeed.setAdapter(recyclerViewExpandableItemManager.createWrappedAdapter(feedAdapter));
	}

	@Override
	public void bind (MainInterface.View mainActivity) {
		mainInterfaceView = mainActivity;
	}

	public void unbind(){
		this.mainInterfaceView = null;
	}

	@Override
	public void retrieveData () {
		RXRetrofit.getRxRetrofit().getFeed();
	}

	@Override
	public void updateAdvancedRecyclerView () {
		mainInterfaceView.setAdvancedRecyclerview();

		feedAdapter.setItemList(StaticPosts.getItems());
		feedAdapter.notifyDataSetChanged();
	}
}
