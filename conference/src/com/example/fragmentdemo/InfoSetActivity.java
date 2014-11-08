package com.example.fragmentdemo;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InfoSetActivity extends Activity {

	private EditText text1,text2,text3;
	private int resultCode = 0; 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.infoset);
		Intent intent=getIntent();
		Bundle data=intent.getExtras();
		String name=data.getString("Name");
		String title=data.getString("Title");
		String mailbox=data.getString("Mailbox");
		text1=(EditText)findViewById(R.id.login_edit_account);
		text2=(EditText)findViewById(R.id.login_edit_pwd);
		text3=(EditText)findViewById(R.id.login_edit_mail);
		text1.setText(name);
		text2.setText(title);
		text3.setText(mailbox);
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	public void QueDing(View View)
	{
		SharedPreferences info=getSharedPreferences("PERSON",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=info.edit();
        editor.putString("Name", text1.getText().toString());
        editor.putString("Title", text2.getText().toString());
        editor.putString("Mailbox", text3.getText().toString());  
        editor.commit();
        
		Intent mIntent = new Intent(); 
        mIntent.putExtra("Name", text1.getText().toString());  
        mIntent.putExtra("Title", text2.getText().toString());  
        mIntent.putExtra("Mailbox", text3.getText().toString()); 
        // 设置结果，并进行传送  
        this.setResult(resultCode, mIntent);  
        
        
		this.finish();
	}

	
}