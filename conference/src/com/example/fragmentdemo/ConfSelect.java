package com.example.fragmentdemo;



import java.text.SimpleDateFormat;
import java.util.Date;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ConfSelect extends Activity{
	private ListView listView;
	private Button start;
	ImageTextAdapter adapter;
	public int cur_pos=-1;
	public static ConfSelect instance = null;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.confselect);
		instance=this;

		listView = (ListView)findViewById(R.id.listView1);
		adapter=new ImageTextAdapter(this);
		listView.setAdapter(adapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				for(int i=0;i<parent.getCount();i++)
				{
					View v=parent.getChildAt(i);
					if(position==i)
					{
						v.setBackgroundColor(Color.RED);
						cur_pos=position;
					}
					else
					{
						v.setBackgroundColor(Color.TRANSPARENT);
					}
				}
				
				TextView textView = (TextView)((LinearLayout)view).getChildAt(0);
				Toast.makeText(getApplicationContext(), textView.getText(),
				          Toast.LENGTH_SHORT).show();				
			}
		});  
	}
    
	private class ImageTextAdapter extends BaseAdapter {
    	private LayoutInflater layoutInflater;
		
	    private class ViewHolder {
	    	TextView ConfCap;    
	    	TextView ConfDate; 
	    	TextView ConfParty; 
	    }
		
		public ImageTextAdapter(Context context) {
			layoutInflater = 
				(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return 5;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) 
            {
                convertView = layoutInflater.inflate(R.layout.conflist_item, null);
                viewHolder = new ViewHolder();
                viewHolder.ConfCap= (TextView) convertView.findViewById(R.id.textView1);
                viewHolder.ConfDate= (TextView) convertView.findViewById(R.id.textView2);
                viewHolder.ConfParty= (TextView) convertView.findViewById(R.id.textView3);
                
                convertView.setTag(viewHolder);
            } 
            else 
            {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            Date createdDate = new    Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ    HH:mm:ss     ");
            String dateString = sdf.format(createdDate);
            viewHolder.ConfCap.setText("Conference"+Integer.toString(position));
            viewHolder.ConfDate.setText(dateString);
            viewHolder.ConfParty.setText("Test Party"+Integer.toString(position));
           /* if(position==cur_pos)
            {
            	convertView.setBackgroundColor(Color.RED);
            }
            else
            {
            	convertView.setBackgroundColor(Color.WHITE);
            }*/
            return convertView;
        }
		
    }
	
	
	public void Start(View view)
	{
		if(cur_pos!=-1)
		{
		Bundle data=new Bundle();
		data.putInt("position", cur_pos);	
		Intent intent = new Intent(ConfSelect.this, MainActivity.class);
		intent.putExtras(data);
    	startActivity(intent);
		}
		 //Intent intent = new Intent();
         //intent.setClass(ConfSelect.this, Message.class);   
         //startActivity(intent); 
	}

}
