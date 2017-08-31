package com.rusi.lbsci720.Activity.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.rusi.lbsci720.Activity.Main.AdvancedRecyclerView.FeedAdapter;
import com.rusi.lbsci720.Network.RXRetrofit;
import com.rusi.lbsci720.R;
import com.rusi.lbsci720.Utility.Constants;
import com.rusi.lbsci720.Utility.LbSci720;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainInterface.View, View.OnClickListener{
	@Inject
	MainInterface.Presenter mainPresenter;

	@BindView(R.id.activity_main_toWebsite)
	TextView textViewToWebsite;
	@BindView(R.id.activity_main_feed_recyclerview)
	RecyclerView recyclerViewFeed;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initialize();
		test();
	}

	private void initialize () {
		bind();
		setOnClickListeners();
		setAdvancedRecyclerview();
	}

	private void setAdvancedRecyclerview () {
		// Setup expandable feature and RecyclerView
		RecyclerViewExpandableItemManager recyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(null);
		recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this));
		recyclerViewFeed.setAdapter(recyclerViewExpandableItemManager.createWrappedAdapter(new FeedAdapter()));
		// NOTE: need to disable change animations to ripple effect work properly
		((SimpleItemAnimator) recyclerViewFeed.getItemAnimator()).setSupportsChangeAnimations(false);

		recyclerViewExpandableItemManager.attachRecyclerView(recyclerViewFeed);
	}

	private void setOnClickListeners () {
		textViewToWebsite.setOnClickListener(this);
	}

	private void bind () {
		((LbSci720) getApplication()).getAppComponent().inject(this);
		ButterKnife.bind(this);
	}

	private void test(){
		RXRetrofit.getRxRetrofit().getFeed();
	}

	@Override
	public void onClick (View v) {
		switch (v.getId()){
			case R.id.activity_main_toWebsite:
				goToWebsite();
				break;
		}
	}

	private void goToWebsite () {
		Uri uriUrl = Uri.parse(Constants.Network.BASE_URL);
		Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
		startActivity(launchBrowser);
	}
}
