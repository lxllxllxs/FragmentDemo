package com.lxl.fragmentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/28.
 */
public class FragmentPageAdatpter extends FragmentPagerAdapter {
	private  Fragment1 f1=null;
	private  Fragment2 f2=null;
	private  Fragment3 f3=null;
	private  Fragment4 f4=null;
	private final int PAGER_COUNT = 4;
	public  FragmentPageAdatpter (FragmentManager fm){
		super(fm);
		f1=new Fragment1();
		f2=new Fragment2();
		f3=new Fragment3();
		f4=new Fragment4();

	}
	@Override
	public Fragment getItem(int position) {
		Fragment fgm=null;
		switch (position){
			case MainActivity.PAGE_ONE:
				fgm=f1;
				break;
			case MainActivity.PAGE_TWE:
				fgm=f2;
				break;
			case MainActivity.PAGE_THREE:
				fgm=f3;
				break;
			case MainActivity.PAGE_FOUR:
				fgm=f4;
				break;
			default:
				break;
		}
		return fgm;
	}

	@Override
	public int getCount() {
		return PAGER_COUNT;
	}



	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		System.out.println("position Destory" + position);
		super.destroyItem(container, position, object);
	}
}
