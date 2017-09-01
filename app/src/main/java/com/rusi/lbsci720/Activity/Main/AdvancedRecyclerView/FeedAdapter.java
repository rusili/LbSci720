package com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.Viewholders.DescriptionViewholder;
import com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.Viewholders.FeedViewholder;
import com.rusi.lbsci720.Model.Item;
import com.rusi.lbsci720.R;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends AbstractExpandableItemAdapter<FeedViewholder, DescriptionViewholder> {
	private List<Item> itemList = new ArrayList <>();

	public FeedAdapter(List<Item> itemList) {
		setHasStableIds(true); // this is required for expandable feature.
		this.itemList = itemList;
	}

	@Override
	public long getGroupId (int groupPosition) {
		return 0;
	}

	@Override
	public long getChildId (int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public FeedViewholder onCreateGroupViewHolder (ViewGroup parent,  int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adv_rv_group_item, parent, false);
		return new FeedViewholder(view);
	}

	@Override
	public DescriptionViewholder onCreateChildViewHolder (ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adv_rv_child_item, parent, false);
		return new DescriptionViewholder(view);
	}

	@Override
	public void onBindGroupViewHolder (FeedViewholder holder, int groupPosition, int viewType) {
		Item group = itemList.get(groupPosition);
		holder.bind(group);
	}

	@Override
	public void onBindChildViewHolder (DescriptionViewholder holder, int groupPosition, int childPosition, int viewType) {
		Item group = itemList.get(groupPosition);
		holder.bind(group.getDescription());
	}

	@Override
	public int getGroupCount () {
		return itemList.size();
	}

	@Override
	public int getChildCount (int groupPosition) {
		return 1;
	}

	@Override
	public boolean onCheckCanExpandOrCollapseGroup (FeedViewholder holder, int groupPosition, int x, int y, boolean expand) {
		return true;
	}
}
