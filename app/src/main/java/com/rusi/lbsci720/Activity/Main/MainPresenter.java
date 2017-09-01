package com.rusi.lbsci720.Activity.Main;

import android.support.v7.widget.RecyclerView;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.FeedAdapter;
import com.rusi.lbsci720.Model.StaticPosts;

public class MainPresenter implements MainInterface.Presenter{

	public void setAdvancedRecyclerviewAdapter(RecyclerView recyclerViewFeed, RecyclerViewExpandableItemManager recyclerViewExpandableItemManager){
		recyclerViewFeed.setAdapter(recyclerViewExpandableItemManager.createWrappedAdapter(new FeedAdapter(StaticPosts.getStaticPosts().getItemList())));
	}
}
