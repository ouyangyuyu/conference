package com.example.fragmentdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ShoucangFragment extends ListFragment {
	
	private ListView ConfDetail;
	private SimpleAdapter adapter2;  

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View messageLayout = inflater.inflate(R.layout.shoucang_layout,
				container, false);
		ConfDetail = (ListView) messageLayout.findViewById(android.R.id.list);  
 
		
        String[] agenda2 = {"亚洲峰会","互联网大会","智能家居"};  
        String[] date2 = {"Nov 12","Dec 8","Jan 25"};
                 
        adapter2 = new SimpleAdapter(getActivity(), getData(agenda2,date2), R.layout.shoucang_item, new String[]{"agenda","date"}, new int[]{R.id.textView1,R.id.textView2});  
        
        setListAdapter(adapter2);  
        
        /*button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setListAdapter(adapter2); 
				button1.setBackgroundResource(R.drawable.btn_style_four_normal);
				button2.setBackgroundResource(R.drawable.btn_style_red);
				button2.setClickable(false);
					}
		});
        button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setListAdapter(adapter1); 
				button2.setBackgroundResource(R.drawable.btn_style_four_normal);
				button1.setBackgroundResource(R.drawable.btn_style_red);
				button1.setClickable(false);
					}
		});*/
		return messageLayout;
	}
  
	
	 @Override  
	 public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);   
	        
	          
	    }  
	 
	 private List<? extends Map<String, ?>> getData(String[] strs,String[] date) {  
	        List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();  
	          
	        for (int i = 0; i < strs.length; i++) {  
	            Map<String, Object> map = new HashMap<String, Object>();  
	            map.put("agenda", strs[i]);  
	            map.put("date", date[i]); 
	            list.add(map);               
	        }  
	          
	        return list;  
	    }  

	 public void onActivityCreated(Bundle savedInstanceState) {  
	        super.onActivityCreated(savedInstanceState);  
	       // Log.i(TAG, "--------onActivityCreated");  
	  
	    }  
	      
	    @Override  
	    public void onAttach(Activity activity) {  
	        super.onAttach(activity);  
	        //Log.i(TAG, "----------onAttach");  
	    } 
	    
}


