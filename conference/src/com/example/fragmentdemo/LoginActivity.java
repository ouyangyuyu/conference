package com.example.fragmentdemo;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	public static LoginActivity instance = null;
	private EditText mAccount;
	private EditText mPwd;
	private Button mRegisterButton;
	private Button mLoginButton;
	private View loginView;
	private View loginSuccessView;
	private TextView loginSuccessShow;
	private UserDataManager mUserDataManager;
	//UserData mUser;
	
	//private Cursor userCursor;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.loginpage);
		
		instance = this;

		mAccount = (EditText) findViewById(R.id.login_edit_account);
		mPwd = (EditText) findViewById(R.id.login_edit_pwd);
		mRegisterButton = (Button) findViewById(R.id.login_btn_register);
		mLoginButton = (Button) findViewById(R.id.login_btn_login);
		
		loginView=findViewById(R.id.login_view);
		loginSuccessView=findViewById(R.id.login_success_view);
		loginSuccessShow=(TextView) findViewById(R.id.login_success_show);

		mRegisterButton.setOnClickListener(mListener);
		mLoginButton.setOnClickListener(mListener);
	
		
		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
        }
	}

	OnClickListener mListener = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_btn_register:
				register();
				break;
			case R.id.login_btn_login:
				login();
				break;
			}
		}
	};

	public void login() {
		if (isUserNameAndPwdValid()) {
			String userName = mAccount.getText().toString().trim();
			String userPwd = mPwd.getText().toString().trim();
			int result=mUserDataManager.findUserByNameAndPwd(userName, userPwd);
			if(result==1){
				//int position=mUserDataManager.findUserByName(userName);
				//userCursor.moveToPosition(position);
				//Bundle bundle=new Bundle();
				//bundle.putString("Name",userCursor.getString())
				Intent intent = new Intent(getApplicationContext(), ConfSelect.class);
		    	startActivity(intent);
				Toast.makeText(this, getString(R.string.login_sucess),
						Toast.LENGTH_SHORT).show();
			}else if(result==0){
				//login failed,user does't exist
				Toast.makeText(this, getString(R.string.login_fail),
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void register() {
		if (isUserNameAndPwdValid()) {
			String userName = mAccount.getText().toString().trim();
			String userPwd = mPwd.getText().toString().trim();
			//check if user name is already exist
			int count=mUserDataManager.findUserByName(userName);
			
			if(count>0){
				Toast.makeText(this, getString(R.string.name_already_exist, userName),
						Toast.LENGTH_SHORT).show();
				return ;
			}
			
			UserData mUser = new UserData(userName, userPwd);
			mUserDataManager.openDataBase();
			long flag = mUserDataManager.insertUserData(mUser);
			if (flag == -1) {
				Toast.makeText(this, getString(R.string.register_fail),
						Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, getString(R.string.register_sucess),
						Toast.LENGTH_SHORT).show();
			}
		}
	}


	public boolean isUserNameAndPwdValid() {
		if (mAccount.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.account_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		} else if (mPwd.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.pwd_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	@Override
	protected void onResume() {
		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
        }
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		if (mUserDataManager != null) {
			mUserDataManager.closeDataBase();
			mUserDataManager = null;
        }
		super.onPause();
	}
}