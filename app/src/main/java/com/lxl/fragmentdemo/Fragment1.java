package com.lxl.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Fragment1 extends Fragment {
	String content="";

	public Fragment1(){};



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view =inflater.inflate(R.layout.fragment1,container,false);
		TextView tv=(TextView)view.findViewById(R.id.tv);
		return  view;
	}
}
