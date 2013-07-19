package com.atanas.tsankov.nfitness.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atanas.tsankov.nfitness.R;
import com.atanas.tsankov.nfitness.SetProgrammeActivity;
import com.atanas.tsankov.nfitness.beans.WorkoutBean;
import com.atanas.tsankov.nfitness.holders.SetProgrammeHolder;

public class SetProgrammeAdapter extends BaseAdapter {
	private List<WorkoutBean> workouts;
	private Context context;

	public SetProgrammeAdapter(List<WorkoutBean> workouts, Context context) {
		this.workouts = workouts;
		this.context = context;
	}

	@Override
	public int getCount() {
		return workouts.size();
	}

	@Override
	public Object getItem(int arg0) {
		return workouts.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		SetProgrammeHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.set_programme_item_layout, null);
			holder = new SetProgrammeHolder();
			convertView.setTag(holder);
		} else {
			holder = (SetProgrammeHolder) convertView.getTag();
		}
		holder.setNameView((TextView) convertView.findViewById(R.id.set_programme_item_name));
		holder.setCloseButton((ImageView) convertView.findViewById(R.id.set_programme_close_btn));
		holder.getNameView().setText(workouts.get(arg0).getName());
		final int position = arg0;
		holder.getCloseButton().setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				workouts.remove(position);
				SetProgrammeActivity activity = (SetProgrammeActivity) context;
				activity.updateJsonInfo();
				notifyDataSetChanged();
			}
		});
		return convertView;
	}

}
