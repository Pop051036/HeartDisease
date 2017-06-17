package com.example.nattapong.heartdisease.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.CommentCollDataDao;
import com.example.nattapong.heartdisease.dao.SampleDataCollection;
import com.example.nattapong.heartdisease.manager.HttpManager;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.internal.zzt.TAG;

/**
 * Created by Nattapong on 12/1/2560.
 */

public class SamplerAdapter extends RecyclerView.Adapter<SamplerAdapter.MyViewHolder>  {

    Context mContext;
    SampleDataCollection data;
    private ArrayList<Integer> ans;
    public SampleDataCollection getData() {
        return data;
    }

    public void setData(SampleDataCollection data) {
        this.data = data;
    }

    public SamplerAdapter(Context mContext) {
        this.mContext = mContext;
        ans = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            ans.add(0);
        }
    }

    @Override
    public SamplerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.list_item_sample, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SamplerAdapter.MyViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: position "+position+" ans.get(position) "+ans.get(position));
            switch (ans.get(position)){
                case 1:  holder.tvText_sampleO.setChecked(true); break;
                case 2:  holder.tvText_sampleT.setChecked(true); break;
                case 3:  holder.tvText_sampleTe.setChecked(true); break;
                case 4:  holder.tvText_sampleF.setChecked(true); break;
                default: holder.radioGroup.clearCheck();
            }
        holder.btnCheck.setVisibility(View.GONE);
        if (position == getItemCount()-1){
            holder.btnCheck.setVisibility(View.VISIBLE);
        }

        String ex  = data.getData().get(position).getDbSampleProposition();
        String choose1  = data.getData().get(position).getDbSampleCheckOne();
        String choose2  = data.getData().get(position).getDbSampleCheckTwo();
        String choose3  = data.getData().get(position).getDbSampleCheckThree();
        String choose4  = data.getData().get(position).getDbSampleCheckFour();
        holder.tvText_sampleData.setText((position+1) + ". "+ ex);
        holder.tvText_sampleO.setText(choose1);
        holder.tvText_sampleT.setText(choose2);
        holder.tvText_sampleTe.setText(choose3);
        holder.tvText_sampleF.setText(choose4);
        holder.tvText_sampleO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ans","position "+position+" "+" choose1");

                ans.set(position,1);

                Log.e("ans11","Array"+ans);
            }
        });
        holder.tvText_sampleT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ans","position "+position+" "+" choose2");

                ans.set(position,2);

                Log.e("ans11","Array"+ans);
            }
        });
        holder.tvText_sampleTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ans","position "+position+" "+" choose3");
                ans.set(position,3);

                Log.e("ans11","Array"+ans);
            }
        });
        holder.tvText_sampleF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ans","position "+position+" "+" choose4");
                ans.set(position,4);

                Log.e("ans11","Array"+ans);
            }
        });

        holder.btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChooseSuccess = true;
                int countAns = 0;
                for (int i = 0; i < ans.size(); i++) {
                    if (ans.get(i) == 0){
                        isChooseSuccess = false;
                    }
                }
                if (isChooseSuccess) {
                    countAns=0;
                    for (int i = 0; i < ans.size(); i++) {
                        Log.d(TAG, "onClick: position: "+i);
                        Log.d(TAG, "onClick: getDbSampleAnswer: "+data.getData().get(i).getDbSampleAnswer());
                        Log.d(TAG, "onClick: ans: "+ans.get(i));
                        if (data.getData().get(i).getDbSampleAnswer() == ans.get(i)){
                            countAns++;
                            Log.d(TAG, "onClick: countAns: "+countAns);
                        }
                    }

                    // Handle ทำตรงนี้ให้ลิ้งไปหน้าไหน

                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setCancelable(false);
                    builder.setMessage("            ผลการทำแบบทดสอบ                รวมคะแนนทั้งหมดที่คุณทำได้  "+countAns+"/20");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Do something
                            for (int i = 0; i < ans.size(); i++) {
                                ans.set(i,0);

                            }
                            notifyDataSetChanged();
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    // Handle ทำตรงนี้ให้ลิ้งไปหน้าไหน  ^^^^^^
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setCancelable(false);
                    builder.setMessage("กรุณาระบุให้ครบทุกข้อ");
                    builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Do something
                            dialog.dismiss();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        if (data.getData() == null) return 0;
        return data.getData().size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvText_sampleData;
        RadioButton tvText_sampleO;
        RadioButton tvText_sampleT;
        RadioButton tvText_sampleTe;
        RadioButton tvText_sampleF;
        RadioGroup radioGroup;
        Button btnCheck;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvText_sampleData = (TextView) itemView.findViewById(R.id.tvText_sampleData);
            tvText_sampleO = (RadioButton) itemView.findViewById(R.id.tvText_sampleO);
            tvText_sampleT = (RadioButton) itemView.findViewById(R.id.tvText_sampleT);
            tvText_sampleTe = (RadioButton) itemView.findViewById(R.id.tvText_sampleTe);
            tvText_sampleF = (RadioButton) itemView.findViewById(R.id.tvText_sampleF);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.radioGroup);
            btnCheck = (Button) itemView.findViewById(R.id.btnCheck);
        }
    }
}
