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
	        String content1="��ν��Ϣ���ͣ�����web�㲥����ͨ��һ���ļ�����׼��Э�飬" +
	        		"�ڻ�������ͨ�����ڴ����û���Ҫ����Ϣ��������Ϣ���ص�һ���¼�����" +
	        		"���ͼ���ͨ���Զ�������Ϣ���û�������������������������ʱ�䡣" +
	        		"�������û�����Ȥ��������������Ϣ�������䶨���Ƹ��û��������û���Ч�ʵط����м�ֵ����Ϣ";
	        String content2="�Ӽ������ԣ���Ϣ������һ���������ھ���Ȼ���Դ����Լ��������ȶ��ż���Ϊ" +
	        		"�������ۺ��Է��򡣽����ʵ���Ϣ���͸����ʵ��ˣ���һ�����ս�Ĺ��������������Ҫ����Ϣ��" +
	        		"��ֵķ����������˵���Ȥ����Ϊ��ϸ�µĿ̻����������߽�����Чƥ�䡣";
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


