package com.rusi.lbsci720.Model;

public class StaticPosts {
	private static StaticPosts staticPosts;

	private StaticPosts(){}

	public static StaticPosts getStaticPosts(){
		if (staticPosts == null){
			staticPosts = new StaticPosts();
		}
		return staticPosts;
	}

	public void addPost (Post[] posts) {

	}
}
