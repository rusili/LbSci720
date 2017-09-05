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
import com.rusi.lbsci720.Dagger.DaggerApplication;
import com.rusi.lbsci720.Model.StaticPosts;
import com.rusi.lbsci720.R;
import com.rusi.lbsci720.Utility.Constants;

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
	}

	private void initialize () {
		((DaggerApplication) getApplication()).getAppComponent().inject(this);
		StaticPosts staticPosts = new StaticPosts(mainPresenter);

		bind();
		setOnClickListeners();
		setAdvancedRecyclerview();
		retrieveData();
	}

	private void retrieveData () {
		mainPresenter.retrieveData();
	}

	public void setAdvancedRecyclerview () {
		// Setup expandable feature and RecyclerView
		RecyclerViewExpandableItemManager recyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(null);
		recyclerViewFeed.setLayoutManager(new LinearLayoutManager(this));
		// NOTE: need to disable change animations to ripple effect work properly
		((SimpleItemAnimator) recyclerViewFeed.getItemAnimator()).setSupportsChangeAnimations(false);
		mainPresenter.setAdvancedRecyclerviewAdapter(recyclerViewFeed, recyclerViewExpandableItemManager);

		recyclerViewExpandableItemManager.attachRecyclerView(recyclerViewFeed);
	}

	private void setOnClickListeners () {
		textViewToWebsite.setOnClickListener(this);
	}

	private void bind () {
		ButterKnife.bind(this);
		mainPresenter.bind(this);
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

	@Override
	protected void onStop () {
		mainPresenter.unbind();
		super.onStop();
	}
}
