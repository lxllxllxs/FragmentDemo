package com.lxl.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

	/*@Bind(R.id.tipstv)
		TextView tipstv;
		@Bind(R.id.informtv)
		TextView informtv;
		@Bind(R.id.mytv)
		TextView mytv;
		@Bind(R.id.settingtv)
		TextView settingtv;
		Fragment1 f1,f2,f3,f4;
		FragmentTransaction ft;
		*/
	public final static int PAGE_ONE = 0;
	public final static int PAGE_TWE = 1;
	public final static int PAGE_THREE = 2;
	public final static int PAGE_FOUR = 3;

	private ViewPager vpager;
	private FragmentPageAdatpter fpa;
	private FragmentTabHost mfth;
	private Class[] fragments = {Fragment1.class, Fragment2.class, Fragment3.class, Fragment4.class};
	private int[] imags = {
			R.drawable.zonghe,
			R.drawable.dongtai,
			R.drawable.faxian,
			R.drawable.wode};
	private String[] text = {"综合", "动态", "信息", "我的"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initview();
	}
//
//	@OnClick({R.id.tipstv, R.id.informtv, R.id.mytv, R.id.settingtv})
//	public void onClick(View view) {
//	//	setSelectFalse();
//		ft=getFragmentManager().beginTransaction();
//		hideAllFragment(ft);
//		switch (view.getId()) {
//			case R.id.tipstv:
//				if (f1==null) {
//					f1 = new Fragment1("tips");
//					ft.add(R.id.fl,f1);;
//				}else{
//					ft.show(f1);
//				}
//				break;
//			case R.id.informtv:
//				if (f2==null) {
//					f2 = new Fragment1("information");
//					ft.add(R.id.fl,f2);;
//				}else{
//					ft.show(f2);
//				}
//				break;
//			case R.id.mytv:
//				if (f3==null) {
//					f3 = new Fragment1("myhome");
//					ft.add(R.id.fl,f3);;
//				}else{
//					ft.show(f3);
//				}
//				break;
//			case R.id.settingtv:
//				if (f4==null) {
//					f4 = new Fragment1("setting");
//					ft.add(R.id.fl,f4);;
//				}else{
//					ft.show(f4);
//				}
//				break;
//		}
//		ft.commit();
//	}
//
//	public  void setSelectFalse(){
//		tipstv.setSelected(false);
//		informtv.setSelected(false);
//		mytv.setSelected(false);
//		settingtv.setSelected(false);
//	}
//
//	//隐藏所有Fragment
//	private void hideAllFragment(FragmentTransaction fragmentTransaction){
//		if(f1 != null)fragmentTransaction.hide(f1);
//		if(f2 != null)fragmentTransaction.hide(f2);
//		if(f3 != null)fragmentTransaction.hide(f3);
//		if(f4 != null)fragmentTransaction.hide(f4);
//	}

	public void initview() {
		fpa = new FragmentPageAdatpter(getSupportFragmentManager());
		vpager = (ViewPager) findViewById(R.id.vpager);
		vpager.setAdapter(fpa);
		vpager.setCurrentItem(0);
		vpager.addOnPageChangeListener(this);
		mfth=(FragmentTabHost)findViewById(android.R.id.tabhost);
		mfth.setup(this,getSupportFragmentManager(),R.id.realContent);
		for(int i=0;i<4;i++) {
			TabHost.TabSpec spec = mfth.newTabSpec(text[i]).setIndicator(getView(i));
			mfth.addTab(spec, fragments[i], null);
		}




	}


	public View getView(int i) {
		View view = View.inflate(this, R.layout.tabcontent, null);
		TextView tv = (TextView) view.findViewById(R.id.tv);
		ImageView iv = (ImageView) view.findViewById(R.id.iv);
		tv.setText(text[i]);
		iv.setImageResource(imags[i]);
		return view;
	}


	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {

	}

	@Override
	public void onPageScrollStateChanged(int state) {
		if (state == 2) {
			switch (vpager.getCurrentItem()) {
				case PAGE_ONE:
					vpager.setCurrentItem(PAGE_ONE);
					break;
				case PAGE_TWE:
					vpager.setCurrentItem(PAGE_TWE);
					break;
				case PAGE_THREE:
					vpager.setCurrentItem(PAGE_THREE);
					break;
				case PAGE_FOUR:
					vpager.setCurrentItem(PAGE_FOUR);
					break;
			}
		}
	}

}