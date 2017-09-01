package com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.Viewholders;

import android.view.View;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.rusi.lbsci720.Model.Item;
import com.rusi.lbsci720.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedViewholder extends AbstractExpandableItemViewHolder {
	@BindView(R.id.adv_rv_group_date2)
	TextView textView;

	public FeedViewholder (View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
//		textView = (TextView) itemView.findViewById(R.id.adv_rv_group_text1);
	}

	public void bind (Item group) {
		textView.setText(group.getTitle());
	}
}
