package com.rusi.lbsci720.Network;

import com.rusi.lbsci720.Model.Post;
import com.rusi.lbsci720.Utility.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FeedAPI {

	@GET (Constants.Network.ENDPOINT)
	Observable<Post[]> getPost ();
}
