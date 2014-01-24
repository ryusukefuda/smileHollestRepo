package hollest.hollest.hollest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import hollest.hollest.hollest.R;

public class MainFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "section_number";
	public static final String ARG_SECTION_MESSAGE = "section_message";

	/**
	 * �t���O�����g�̃R���X�g���N�^�𐶐�����ƌĂ΂��B
	 * �t���O�����g��View���`���āA�Ԃ��B
	 * */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		/**
		 * xml�𓮓I�ɓǂݍ��ނ̂�inflater�B
		 * */
		View rootView = inflater.inflate(R.layout.fragment_main,
				container, false);
		TextView message = (TextView) rootView.findViewById(R.id.message_text);
		message.setText(getArguments().getString(ARG_SECTION_MESSAGE));
		ImageView photo = (ImageView)rootView.findViewById(R.id.photo_image);
		
		/**
		 * ������ŕ\������摜��ύX�B
		 * */
		if (getArguments().getInt(ARG_SECTION_NUMBER) % 2 == 1) {
			photo.setImageResource(R.drawable.sotoyama);
		}else {
			photo.setImageResource(R.drawable.yamanaka);
		}
		
		return rootView;
	}

}
