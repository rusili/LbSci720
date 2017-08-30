package com.rusi.lbsci720.Activity.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rusi.lbsci720.Network.RXRetrofit;
import com.rusi.lbsci720.R;
import com.rusi.lbsci720.Utility.LbSci720;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainInterface.View{
	@Inject
	MainInterface.Presenter mainPresenter;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initialize();
		test();
	}

	private void initialize () {
		bind();
	}

	private void bind () {
		((LbSci720) getApplication()).getAppComponent().inject(this);
		ButterKnife.bind(this);
	}

	private void test(){
		RXRetrofit.getRxRetrofit().getFeed();
	}
}
