package com.rusi.lbsci720.Activity.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rusi.lbsci720.Network.RXRetrofit;
import com.rusi.lbsci720.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		test();
	}

	private void test(){
		RXRetrofit.getRxRetrofit().getFeed();
	}
}
