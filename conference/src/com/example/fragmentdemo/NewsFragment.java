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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class NewsFragment extends ListFragment {
	
	private ListView messageDetail;
	private SimpleAdapter adapter;  

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View newsLayout = inflater.inflate(R.layout.news_layout,
				container, false);
		messageDetail = (ListView) newsLayout.findViewById(android.R.id.list);  
		
		return newsLayout;
	}
  
	
	 @Override  
	 public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState); 
	        String content1="所谓信息推送，就是web广播，是通过一定的技术标准或协议，" +
	        		"在互联网上通过定期传送用户需要的信息来减少信息过载的一项新技术。" +
	        		"推送技术通过自动传送信息给用户，来减少用于网络上搜索的时间。" +
	        		"它根据用户的兴趣来搜索、过滤信息，并将其定期推给用户，帮助用户高效率地发掘有价值的信息";
	        String content2="从技术而言，信息推送是一项以数据挖掘、自然语言处理以及互联网等多门技术为" +
	        		"基础的综合性方向。将合适的信息推送给合适的人，是一项极具挑战的工作。这个过程需要对信息作" +
	        		"充分的分析，并对人的兴趣、行为做细致的刻画，并对两者进行有效匹配。";
	        String[] agenda = {content1, content2};  
	      
	        adapter = new SimpleAdapter(getActivity(), getData(agenda), R.layout.message_item, new String[]{"content"}, new int[]{R.id.TextView1});  
	        setListAdapter(adapter);  
	          
	    }  
	 
	 private List<? extends Map<String, ?>> getData(String[] strs) {  
	        List<Map<String ,Object>> list = new ArrayList<Map<String,Object>>();  
	          
	        for (int i = 0; i < strs.length; i++) {  
	            Map<String, Object> map = new HashMap<String, Object>();  
	            map.put("content", strs[i]);  
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


