package com.example.fragmentdemo;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingFragment extends Fragment {

	private RelativeLayout layout1,layout2,layout3,layout4,layout5,layout6;
	private TextView text1,text2,text3;
	private Button Exit;
	private ImageView pushbutton;
	private boolean push=true;
	private int requestCode;
	private String name, title, mailbox;
	
	 public void onCreate(Bundle savedInstanceState) 
	 {  
	        super.onCreate(savedInstanceState);   	       	          
	    } 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View settingLayout = inflater.inflate(R.layout.setting_layout,
				container, false);
		layout1=(RelativeLayout) settingLayout.findViewById(R.id.layout1);
		layout2=(RelativeLayout) settingLayout.findViewById(R.id.layout2);
		layout3=(RelativeLayout) settingLayout.findViewById(R.id.layout3);
		layout4=(RelativeLayout) settingLayout.findViewById(R.id.layout4);
		layout5=(RelativeLayout) settingLayout.findViewById(R.id.layout5);
		layout6=(RelativeLayout) settingLayout.findViewById(R.id.layout6);
		
		text1=(TextView)settingLayout.findViewById(R.id.text1);
		text2=(TextView)settingLayout.findViewById(R.id.text2);
		text3=(TextView)settingLayout.findViewById(R.id.text3);
		Exit=(Button)settingLayout.findViewById(R.id.button1);
		pushbutton=(ImageView)settingLayout.findViewById(R.id.image5);
		
		SharedPreferences info=getActivity().getSharedPreferences("PERSON",Activity.MODE_PRIVATE);
		name =info.getString("Name", ""); 
		title =info.getString("Title", ""); 
		mailbox=info.getString("Mailbox", "");
		text1.setText("姓名: "+name);
		text2.setText("职位: "+title);
		text3.setText("邮箱: "+mailbox);
		
		layout1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Intent intent=new Intent(getActivity(), InfoSetActivity.class);
				Bundle data=new Bundle();
				data.putString("Name", (String) text1.getText());
				data.putString("Title", (String) text2.getText());
				data.putString("Mail", (String) text3.getText());
				intent.putExtras(data);
				startActivity(intent);*/
				Intent mIntent = new Intent();
				mIntent.setClass(getActivity(),  InfoSetActivity.class);  
				Bundle data=new Bundle();
				data.putString("Name", name);
				data.putString("Title", title);
				data.putString("Mailbox", mailbox);
				mIntent.putExtras(data);
				requestCode = 0;  
	            startActivityForResult(mIntent, requestCode); 
					}
		});
		
		layout2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), NamecardActivity.class));
					}
		});

		layout3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getActivity(), ConfirmActivity.class));
			}
});

		layout4.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getActivity(), FeedbackActivity.class));
			}
});

		layout5.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(push==true)
		{
			pushbutton.setImageResource(R.drawable.send_forbid);
			push=false;
		}
		else
		{
			pushbutton.setImageResource(R.drawable.send_open);
			push=true;
		}
	}
});

		layout6.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		startActivity(new Intent(getActivity(), AboutActivity.class));
			}
});
		
		Exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), ExitFromSettings.class));
					}
		});
		return settingLayout;
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {  
        name = data.getStringExtra("Name");  
        title = data.getStringExtra("Title");  
        mailbox = data.getStringExtra("Mailbox"); 
        // 根据上面发送过去的请求吗来区别  
        switch (requestCode) {  
        case 0:  
        	text1.setText("姓名: "+name);
    		text2.setText("职位: "+title);
    		text3.setText("邮箱: "+mailbox);
            break;   
        default:  
            break;  
        }  
    }  
}
