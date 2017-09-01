package com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.Viewholders;

import android.view.View;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.rusi.lbsci720.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DescriptionViewholder extends AbstractExpandableItemViewHolder {
	@BindView(R.id.adv_rv_child_text1)
	TextView textView;

	public DescriptionViewholder (View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void bind (String description) {
		textView.setText(description);
	}
}
