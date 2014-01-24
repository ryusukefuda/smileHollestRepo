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
		 * �y�[�W���[�ɃJ�X�^���y�[�W���[���Z�b�g�B
		 * ��ʂɌ����Ă���X���C�v�ł����ʂ́A����MainActivity��ViewPager�B
		 * �r���[�y�[�W���[�Ƀt���O�����g���������ǉ����Ă���B
		 * */
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}

	/**
	 * �A�N�V�����o�[�Ƀ��j���[��ǉ��B
	 * xml�Œ�`���Ă����ꍇ�������B
	 * ����͒P���Ȃ��̂Ȃ̂�for���ŌJ��Ԃ��쐬�����B
	 * */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		for (int i=0; i<mNumber; i++) {
			menu.add(Menu.NONE, i, Menu.FIRST, mNumberArray[i]);
		}
		return true;
	}

	/**
	 * �J�X�^���y�[�W���[�A�_�v�^�[�B
	 * 
	 * */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		/**
		 * �t���O�����g�𐶐����ĕԂ��B
		 * */
		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new MainFragment();
			Bundle args = new Bundle();
			/**
			 * Bundle�ɒl���߂āA�t���O�����g�ɓn���Ă���B
			 * */
			args.putString(MainFragment.ARG_SECTION_MESSAGE, "messsage : "+ position);
			args.putInt(MainFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		/**
		 * �y�[�W���[�̖������w��B
		 * */
		@Override
		public int getCount() {
			return mNumber;
		}

		/**
		 * �y�[�W���[�̃^�C�g�����w�肵�����̂ɕύX�B
		 * */
		@Override
		public CharSequence getPageTitle(int position) {
			return mNumberArray[position];
		}
	}

	/**
	 * ���j���[���������Ƃ��̋����B
	 * �ʏ��switch���ȂǂŁA�����𐧌䂷��B
	 * ����͓��������i�w�肵���y�[�W�ɔ�΂��j�Ȃ̂ŏȗ��B
	 * */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Toast.makeText(getApplicationContext(), item.getItemId()+"", Toast.LENGTH_SHORT).show();

		/**
		 * �w�肵���y�[�W�ɔ�΂��B
		 * */
		mViewPager.setCurrentItem(item.getItemId());
		
		return super.onMenuItemSelected(featureId, item);
	}
	
	


}
