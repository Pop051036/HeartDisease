package com.example.nattapong.heartdisease.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.activity.MapActivity;
import com.example.nattapong.heartdisease.dao.MapHospitalDataCollection;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Nattapong on 23/5/2560.
 */

public class MapHospitalAdapter  extends RecyclerView.Adapter<MapHospitalAdapter.MyViewHolder> {

    private MapHospitalDataCollection data;


    public void setData(MapHospitalDataCollection data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_hospital, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        if (position < getItemCount()) {
            holder.name.setText(data.getData().get(position).getDbMapName());
            holder.map1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),MapActivity.class);
                    intent.putExtra("data",data.getData().get(position));
                    v.getContext().startActivity(intent);
                    Log.d(TAG, "onClick: asasdasdasdadasd");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        if (data.getData() == null) return 0;
        Log.d(TAG, "getItemCount: "+data.getData().size());
        return data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout lin;
        TextView name;
        CardView map1;
        public MyViewHolder(View itemView) {
            super(itemView);
            lin = (LinearLayout) itemView.findViewById(R.id.linLayout);
            map1 = (CardView) itemView.findViewById(R.id.map1);
            name = (TextView) itemView.findViewById(R.id.nameHospital);
        }
    }
}
