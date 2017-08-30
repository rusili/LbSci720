package com.rusi.lbsci720.Network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.rusi.lbsci720.Model.Rss;
import com.rusi.lbsci720.Model.StaticPosts;
import com.rusi.lbsci720.Utility.Constants;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RXRetrofit {
	private static RXRetrofit rxRetrofit;

	private RXRetrofit(){}

	public static RXRetrofit getRxRetrofit(){
		if (rxRetrofit == null){
			rxRetrofit = new RXRetrofit();
		}
		return rxRetrofit;
	}

	private Retrofit provideRetrofit(){
		Retrofit retrofit = new Retrofit.Builder()
			  .baseUrl(Constants.Network.BASE_URL)
			  .addConverterFactory(SimpleXmlConverterFactory.create())
			  .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			  .build();
		return retrofit;
	}

	public void getFeed(){
		Retrofit retrofit = provideRetrofit();
		FeedAPI feedAPI = retrofit.create(FeedAPI.class);

		Observable<Rss> feedRXObservable = feedAPI.getRss();
		feedRXObservable.subscribeOn(Schedulers.newThread())
			  .observeOn(AndroidSchedulers.mainThread())
			  .subscribe((rss -> {
				  StaticPosts.getStaticPosts().addRss(rss);
			  }));
	}
}
