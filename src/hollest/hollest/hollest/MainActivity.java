package hollest.hollest.hollest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import hollest.hollest.hollest.R;

public class MainActivity extends FragmentActivity {

	private SectionsPagerAdapter mSectionsPagerAdapter;
	private ViewPager mViewPager;
	private int mNumber;
	private String[] mNumberArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mNumberArray = getResources().getStringArray(R.array.names);
		mNumber = mNumberArray.length;
		
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		
		/**
		 * ページャーにカスタムページャーをセット。
		 * 画面に見えているスワイプできる画面は、このMainActivityのViewPager。
		 * ビューページャーにフラグメントをいくつも追加している。
		 * */
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}

	/**
	 * アクションバーにメニューを追加。
	 * xmlで定義しておく場合が多い。
	 * 今回は単純なものなのでfor文で繰り返し作成した。
	 * */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		for (int i=0; i<mNumber; i++) {
			menu.add(Menu.NONE, i, Menu.FIRST, mNumberArray[i]);
		}
		return true;
	}

	/**
	 * カスタムページャーアダプター。
	 * 
	 * */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		/**
		 * フラグメントを生成して返す。
		 * */
		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new MainFragment();
			Bundle args = new Bundle();
			/**
			 * Bundleに値をつめて、フラグメントに渡している。
			 * */
			args.putString(MainFragment.ARG_SECTION_MESSAGE, "messsage : "+ position);
			args.putInt(MainFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		/**
		 * ページャーの枚数を指定。
		 * */
		@Override
		public int getCount() {
			return mNumber;
		}

		/**
		 * ページャーのタイトルを指定したものに変更。
		 * */
		@Override
		public CharSequence getPageTitle(int position) {
			return mNumberArray[position];
		}
	}

	/**
	 * メニューを押したときの挙動。
	 * 通常はswitch文などで、挙動を制御する。
	 * 今回は同じ挙動（指定したページに飛ばす）なので省略。
	 * */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Toast.makeText(getApplicationContext(), item.getItemId()+"", Toast.LENGTH_SHORT).show();

		/**
		 * 指定したページに飛ばす。
		 * */
		mViewPager.setCurrentItem(item.getItemId());
		
		return super.onMenuItemSelected(featureId, item);
	}
	
	


}
