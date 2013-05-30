package com.example.wecharades.presenter;

import java.util.LinkedHashMap;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.example.wecharades.R;

/**
 * Presenter-help-class intended to manage the creation of a sectioned ListView
 * @author weCharade
 */
public class SeparatedListAdapter extends BaseAdapter {
	public final Map<String, Adapter> sections = new LinkedHashMap<String, Adapter>();
	public final ArrayAdapter<String> headers;
	public final static int TYPE_SECTION_HEADER = 0;

	/**
	 * Create an instance of SeparatedListAdapter
	 * @param context
	 */
	public SeparatedListAdapter(Context context) {
		//Headers are displayed by using a regular ArrayAdapter 
		this.headers = new ArrayAdapter<String>(context, R.layout.list_section, R.id.list_header_title);
	}

	/**
	 * Add header for a section and link it to an adapter
	 * @param section
	 * @param adapter
	 */
	public void addSection(String section, Adapter adapter) {
		//Every header are added in order to be displayed
		this.headers.add(section);

		/*
		 * Each header are linked to a adapter in a LinkedHashMap, thus each key holds the adapter used
		 * to display the list elements in the specific header
		 */
		this.sections.put(section, adapter);
	}

	@Override
	public Object getItem(int position) {
		
		for (Object section : this.sections.keySet()){
			
			Adapter adapter = sections.get(section);
			int size = adapter.getCount() + 1;

			// check if position inside this section
			if (position == 0) return section;
			if (position < size) return adapter.getItem(position - 1);

			// otherwise jump into next section
			position -= size;
		}
		return null;
	}

	@Override
	public int getCount() {
		// total together all sections, plus one for each section header
		int total = 0;
		for (Adapter adapter : this.sections.values())
			total += adapter.getCount() + 1;
		return total;
	}

	@Override
	public int getViewTypeCount() {
		// assume that headers count as one, then total all sections
		int total = 1;
		for (Adapter adapter : this.sections.values())
			total += adapter.getViewTypeCount();
		return total;
	}

	@Override
	public int getItemViewType(int position) {
		int type = 1;
		for (Object section : this.sections.keySet()) {
			Adapter adapter = sections.get(section);
			int size = adapter.getCount() + 1;

			// check if position inside this section
			if (position == 0) return TYPE_SECTION_HEADER;
			if (position < size) return type + adapter.getItemViewType(position - 1);

			// otherwise jump into next section
			position -= size;
			type += adapter.getViewTypeCount();
		}
		return -1;
	}

	public boolean areAllItemsSelectable() {
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		return (getItemViewType(position) != TYPE_SECTION_HEADER);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int sectionnum = 0;
		for (Object section : this.sections.keySet()) {
			
			Adapter adapter = sections.get(section);
			int size = adapter.getCount() + 1;

			// check if position inside this section
			if (position == 0) return headers.getView(sectionnum, convertView, parent);
			if (position < size) return adapter.getView(position - 1, convertView, parent);

			// otherwise jump into next section
			position -= size;
			sectionnum++;
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
