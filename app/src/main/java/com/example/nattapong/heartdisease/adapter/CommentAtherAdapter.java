package com.example.nattapong.heartdisease.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.CommentCollDataDao;
import com.example.nattapong.heartdisease.dao.CommentInsertDao;
import com.example.nattapong.heartdisease.manager.HttpManager;
import com.example.nattapong.heartdisease.manager.UserDataLoginManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nattapong on 12/1/2560.
 */

public class CommentAtherAdapter extends RecyclerView.Adapter<CommentAtherAdapter.MyViewHolder>{

    Context mContext;
    CommentCollDataDao data;
    UserDataLoginManager userDataLoginManager = new UserDataLoginManager();

    public CommentCollDataDao getData() {
        return data;
    }

    public void setData(CommentCollDataDao data) {
        this.data = data;
    }

    public CommentAtherAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public CommentAtherAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.card_comment, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CommentAtherAdapter.MyViewHolder holder, final int position) {

        if (position < getItemCount()){
            holder.cmUser.setText(data.getData().get(position).getCommentUserText());
            holder.userDate.setText(data.getData().get(position).getCommentUserDate());
            holder.userName.setText(data.getData().get(position).getCommentUserName());
            if (data.getData().get(position).getCommentAdminText() != null){
                holder.r2.setVisibility(View.VISIBLE);
                holder.cmAdmin.setText(data.getData().get(position).getCommentAdminText());
                holder.adminDate.setText(data.getData().get(position).getCommentAdminDate());
            }else {
                holder.r2.setVisibility(View.GONE);
            }
            if (userDataLoginManager.getUser() != null){
                holder.r3.setVisibility(View.VISIBLE);
            }else {
                holder.r3.setVisibility(View.GONE);
            }

            holder.btnCommentP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = data.getData().get(position).getCommentId();
                    String textComment = holder.edcmAdmin.getText().toString();
                    int adminId = userDataLoginManager.getUser().getUser().get(0).getUserId();
                    Call<CommentCollDataDao> call = HttpManager
                            .getInstance()
                            .getService()
                            .commentadmin(id, adminId, textComment);
                    call.enqueue(new Callback<CommentCollDataDao>() {
                        @Override
                        public void onResponse(Call<CommentCollDataDao> call, Response<CommentCollDataDao> response) {
                            if (response.isSuccessful()){
                                Log.e("admincomment", "บันทึกสำเร็จ");
                                notifyItemRangeRemoved(0,getItemCount());
                                data.getData().clear();
                                CommentCollDataDao dao = response.body();
                                data.setData(dao.getData());
                                notifyItemRangeChanged(0,getItemCount());
                            }else {
                                Log.e("admincomment1", response.errorBody().toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<CommentCollDataDao> call, Throwable t) {

                            Log.e("admincomment2", t.toString());
                        }
                    });
                }
            });



        }
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        if (data.getData() == null) return 0;
        return data.getData().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cmUser;
        TextView cmAdmin;
        TextView adminDate;
        TextView userDate;
        TextView userName;
        RelativeLayout r2;
        RelativeLayout r3;
        EditText edcmAdmin;
        TextView btnCommentP;

        public MyViewHolder(View itemView) {
            super(itemView);
            cmUser = (TextView) itemView.findViewById(R.id.cmUser);
            cmAdmin = (TextView) itemView.findViewById(R.id.cmAdmin);
            adminDate = (TextView) itemView.findViewById(R.id.adminDate);
            userDate = (TextView) itemView.findViewById(R.id.userDate);
            userName = (TextView) itemView.findViewById(R.id.userName);
            r2 = (RelativeLayout) itemView.findViewById(R.id.r2);
            r3 = (RelativeLayout) itemView.findViewById(R.id.r3);
            edcmAdmin = (EditText) itemView.findViewById(R.id.edcmAdmin);
            btnCommentP = (TextView) itemView.findViewById(R.id.btnCommentP);



        }
    }
}
