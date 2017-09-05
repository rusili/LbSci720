package com.rusi.lbsci720.Activity.Main;

import android.support.v7.widget.RecyclerView;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

public interface MainInterface {

	interface View{
		void setAdvancedRecyclerview ();
	}

	interface Presenter{
		public void setAdvancedRecyclerviewAdapter(RecyclerView recyclerViewFeed, RecyclerViewExpandableItemManager recyclerViewExpandableItemManager);

		void bind (MainInterface.View mainActivity);
		void unbind();

		void retrieveData ();

		void updateAdvancedRecyclerView ();
	}

	interface Model{
		
	}
}
