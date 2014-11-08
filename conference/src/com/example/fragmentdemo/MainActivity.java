package com.example.fragmentdemo;


import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;

/**
 * 椤圭洰鐨勪富Activity锛屾墍鏈夌殑Fragment閮藉祵鍏ュ湪杩欓噷銆�
 * 
 * @author guolin
 */
public class MainActivity extends Activity implements OnClickListener {
	public static MainActivity instance = null;

	/**
	 * 鐢ㄤ簬灞曠ず娑堟伅鐨凢ragment
	 */
	private MessageFragment messageFragment;

	/**
	 * 鐢ㄤ簬灞曠ず鑱旂郴浜虹殑Fragment
	 */
	private ShoucangFragment shoucangFragment;

	/**
	 * 鐢ㄤ簬灞曠ず鍔ㄦ�鐨凢ragment
	 */
	private NewsFragment newsFragment;

	/**
	 * 鐢ㄤ簬灞曠ず璁剧疆鐨凢ragment
	 */
	private SettingFragment settingFragment;

	/**
	 * 娑堟伅鐣岄潰甯冨眬
	 */
	private View messageLayout;

	/**
	 * 鑱旂郴浜虹晫闈㈠竷灞�
	 */
	private View shoucangLayout;

	/**
	 * 鍔ㄦ�鐣岄潰甯冨眬
	 */
	private View newsLayout;

	/**
	 * 璁剧疆鐣岄潰甯冨眬
	 */
	private View settingLayout;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀烘秷鎭浘鏍囩殑鎺т欢
	 */
	private ImageView messageImage;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀鸿仈绯讳汉鍥炬爣鐨勬帶浠�
	 */
	private ImageView shoucangImage;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀哄姩鎬佸浘鏍囩殑鎺т欢
	 */
	private ImageView newsImage;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀鸿缃浘鏍囩殑鎺т欢
	 */
	private ImageView settingImage;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀烘秷鎭爣棰樼殑鎺т欢
	 */
	private TextView messageText;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀鸿仈绯讳汉鏍囬鐨勬帶浠�
	 */
	private TextView shoucangText;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀哄姩鎬佹爣棰樼殑鎺т欢
	 */
	private TextView newsText;

	/**
	 * 鍦═ab甯冨眬涓婃樉绀鸿缃爣棰樼殑鎺т欢
	 */
	private TextView settingText;

	/**
	 * 鐢ㄤ簬瀵笷ragment杩涜绠＄悊
	 */
	private FragmentManager fragmentManager;
	
	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		instance = this;
		
		Intent intent=getIntent();
		Bundle data=intent.getExtras();
		position = (int)data.getInt("position");
		
		//SharedPreferences info=getSharedPreferences("info",Activity.MODE_PRIVATE);
		// 鍒濆鍖栧竷灞�厓绱�
		initViews();
		fragmentManager = getFragmentManager();
		// 绗竴娆″惎鍔ㄦ椂閫変腑绗�涓猼ab
		setTabSelection(0);
		
	}

	/**
	 * 鍦ㄨ繖閲岃幏鍙栧埌姣忎釜闇�鐢ㄥ埌鐨勬帶浠剁殑瀹炰緥锛屽苟缁欏畠浠缃ソ蹇呰鐨勭偣鍑讳簨浠躲�
	 */
	private void initViews() {
		messageLayout = findViewById(R.id.message_layout);
		shoucangLayout=findViewById(R.id.shoucang_layout);
		newsLayout = findViewById(R.id.news_layout);
		settingLayout = findViewById(R.id.setting_layout);
		
		messageImage = (ImageView) findViewById(R.id.message_image);
		shoucangImage = (ImageView) findViewById(R.id.shoucang_image);
		newsImage = (ImageView) findViewById(R.id.news_image);
		settingImage = (ImageView) findViewById(R.id.setting_image);
		
		messageText = (TextView) findViewById(R.id.message_text);
		shoucangText = (TextView) findViewById(R.id.shoucang_text);
		newsText = (TextView) findViewById(R.id.news_text);
		settingText = (TextView) findViewById(R.id.setting_text);
		
		messageLayout.setOnClickListener(this);	
		shoucangLayout.setOnClickListener(this);	
		newsLayout.setOnClickListener(this);
		settingLayout.setOnClickListener(this);
		//settingLayout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.message_layout:
			// 褰撶偣鍑讳簡娑堟伅tab鏃讹紝閫変腑绗�涓猼ab
			setTabSelection(0);
			break;
		case R.id.shoucang_layout:
			// 褰撶偣鍑讳簡娑堟伅tab鏃讹紝閫変腑绗�涓猼ab
			setTabSelection(1);
			break;
		case R.id.news_layout:
			// 褰撶偣鍑讳簡鍔ㄦ�tab鏃讹紝閫変腑绗�涓猼ab
			setTabSelection(2);
			break;
		case R.id.setting_layout:
			// 褰撶偣鍑讳簡璁剧疆tab鏃讹紝閫変腑绗�涓猼ab
			setTabSelection(3);
			break;
		default:
			break;
		}
	}

	/**
	 * 鏍规嵁浼犲叆鐨刬ndex鍙傛暟鏉ヨ缃�涓殑tab椤点�
	 * 
	 * @param index
	 *            姣忎釜tab椤靛搴旂殑涓嬫爣銆�琛ㄧず娑堟伅锛�琛ㄧず鑱旂郴浜猴紝2琛ㄧず鍔ㄦ�锛�琛ㄧず璁剧疆銆�
	 */
	private void setTabSelection(int index) {
		// 姣忔閫変腑涔嬪墠鍏堟竻妤氭帀涓婃鐨勯�涓姸鎬�
		clearSelection();
		// 寮�惎涓�釜Fragment浜嬪姟
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// 鍏堥殣钘忔帀鎵�湁鐨凢ragment锛屼互闃叉鏈夊涓狥ragment鏄剧ず鍦ㄧ晫闈笂鐨勬儏鍐�
		hideFragments(transaction);
		switch (index) {
		case 0:
			// 褰撶偣鍑讳簡娑堟伅tab鏃讹紝鏀瑰彉鎺т欢鐨勫浘鐗囧拰鏂囧瓧棰滆壊
			
			messageImage.setImageResource(R.drawable.agenda_press);
			messageText.setTextColor(Color.BLACK);
			if (messageFragment == null) {
				// 濡傛灉MessageFragment涓虹┖锛屽垯鍒涘缓涓�釜骞舵坊鍔犲埌鐣岄潰涓�
				messageFragment = new MessageFragment();
				Bundle bundle0=new Bundle();
				bundle0.putInt("position", position);
				messageFragment.setArguments(bundle0);
				transaction.add(R.id.content, messageFragment);
			} else {
				// 濡傛灉MessageFragment涓嶄负绌猴紝鍒欑洿鎺ュ皢瀹冩樉绀哄嚭鏉�
				transaction.show(messageFragment);
			}
			
			
			break;
		case 1:
			// 褰撶偣鍑讳簡鑱旂郴浜簍ab鏃讹紝鏀瑰彉鎺т欢鐨勫浘鐗囧拰鏂囧瓧棰滆壊
			shoucangImage.setImageResource(R.drawable.shoucang_press);
			shoucangText.setTextColor(Color.BLACK);
			if (shoucangFragment == null) {
				// 濡傛灉ContactsFragment涓虹┖锛屽垯鍒涘缓涓�釜骞舵坊鍔犲埌鐣岄潰涓�
				shoucangFragment = new ShoucangFragment();
				transaction.add(R.id.content, shoucangFragment);
			} else {
				// 濡傛灉ContactsFragment涓嶄负绌猴紝鍒欑洿鎺ュ皢瀹冩樉绀哄嚭鏉�
				transaction.show(shoucangFragment);
			}
			break;
		case 2:
			// 褰撶偣鍑讳簡鑱旂郴浜簍ab鏃讹紝鏀瑰彉鎺т欢鐨勫浘鐗囧拰鏂囧瓧棰滆壊
			newsImage.setImageResource(R.drawable.dyna_press);
			newsText.setTextColor(Color.BLACK);
			if (newsFragment == null) {
				// 濡傛灉ContactsFragment涓虹┖锛屽垯鍒涘缓涓�釜骞舵坊鍔犲埌鐣岄潰涓�
				newsFragment = new NewsFragment();
				transaction.add(R.id.content, newsFragment);
			} else {
				// 濡傛灉ContactsFragment涓嶄负绌猴紝鍒欑洿鎺ュ皢瀹冩樉绀哄嚭鏉�
				transaction.show(newsFragment);
			}
			break;
		case 3:
			// 褰撶偣鍑讳簡鍔ㄦ�tab鏃讹紝鏀瑰彉鎺т欢鐨勫浘鐗囧拰鏂囧瓧棰滆壊
			settingImage.setImageResource(R.drawable.person_press);
			settingText.setTextColor(Color.BLACK);
			if (settingFragment == null) {
				// 濡傛灉NewsFragment涓虹┖锛屽垯鍒涘缓涓�釜骞舵坊鍔犲埌鐣岄潰涓�
				settingFragment = new SettingFragment();
				transaction.add(R.id.content, settingFragment);
			} else {
				// 濡傛灉NewsFragment涓嶄负绌猴紝鍒欑洿鎺ュ皢瀹冩樉绀哄嚭鏉�
				transaction.show(settingFragment);
			}
			break;
		
		}
		transaction.commit();
	}

	/**
	 * 娓呴櫎鎺夋墍鏈夌殑閫変腑鐘舵�銆�
	 */
	private void clearSelection() {
		messageImage.setImageResource(R.drawable.agenda);
		messageText.setTextColor(Color.parseColor("#000000"));
		shoucangImage.setImageResource(R.drawable.shoucang);
		shoucangText.setTextColor(Color.parseColor("#000000"));
		newsImage.setImageResource(R.drawable.dyna);
		newsText.setTextColor(Color.parseColor("#000000"));
		settingImage.setImageResource(R.drawable.person);
		settingText.setTextColor(Color.parseColor("#000000"));
	}

	/**
	 * 灏嗘墍鏈夌殑Fragment閮界疆涓洪殣钘忕姸鎬併�
	 * 
	 * @param transaction
	 *            鐢ㄤ簬瀵笷ragment鎵ц鎿嶄綔鐨勪簨鍔�
	 */
	private void hideFragments(FragmentTransaction transaction) {
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (shoucangFragment != null) {
			transaction.hide(shoucangFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}
		if (newsFragment != null) {
			transaction.hide(newsFragment);
		}
		/*if (settingFragment != null) {
			transaction.hide(settingFragment);
		}*/
	}
}
