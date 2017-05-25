package com.example.nattapong.heartdisease.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.adapter.CommentAtherAdapter;
import com.example.nattapong.heartdisease.dao.CommentCollDataDao;
import com.example.nattapong.heartdisease.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class FragmentComment extends Fragment implements View.OnClickListener {

    private Button ButtonSendFeedback;
    private EditText EditTextFeedbackBody;
    private EditText nameUser;
    private RecyclerView recyclerView;
    private CommentAtherAdapter commentAtherAdapter;

    public FragmentComment() {
        super();
    }

    @SuppressWarnings("unused")
    public static FragmentComment newInstance() {
        FragmentComment fragment = new FragmentComment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_comment, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
        commentAtherAdapter = new CommentAtherAdapter(getContext());
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here

        ButtonSendFeedback = (Button) rootView.findViewById(R.id.ButtonSendFeedback);
        ButtonSendFeedback.setOnClickListener(this);
        EditTextFeedbackBody = (EditText) rootView.findViewById(R.id.EditTextFeedbackBody);
        nameUser = (EditText) rootView.findViewById(R.id.nameUser);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(commentAtherAdapter);

        loadDataComment();
    }

    private void loadDataComment() {
        Call<CommentCollDataDao> call = HttpManager.getInstance().getService()
                .loadComment();
        call.enqueue(new Callback<CommentCollDataDao>() {

            @Override
            public void onResponse(Call<CommentCollDataDao> call, Response<CommentCollDataDao> response) {
                if (response.isSuccessful()) {
                    CommentCollDataDao data = response.body();
                    commentAtherAdapter.setData(data);
                    commentAtherAdapter.notifyDataSetChanged();
                }else {
                    Log.e("sdasd",response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<CommentCollDataDao> call, Throwable t) {

                Log.e("sdasd",t.toString());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance State here
    }

    @Override
    public void onClick(View v) {

        if (v == ButtonSendFeedback) {
            Call<CommentCollDataDao> call = HttpManager.getInstance().getService().commentuser(nameUser.getText().toString(), EditTextFeedbackBody.getText().toString());
            call.enqueue(new Callback<CommentCollDataDao>() {

                @Override
                public void onResponse(Call<CommentCollDataDao> call, Response<CommentCollDataDao> response) {

                    if (response.isSuccessful()) {
                        CommentCollDataDao data = response.body();
                        loadDataComment();
                        EditTextFeedbackBody.setText("");
                        nameUser.setText("");

                    } else {
                        Log.e("atheruser", "แสดงความคิดเห็นผิดพลาด!");
                    }
                }

                @Override
                public void onFailure(Call<CommentCollDataDao> call, Throwable t) {

                    Log.e("atheruser", t.toString());
                }
            });
        }
    }
}
