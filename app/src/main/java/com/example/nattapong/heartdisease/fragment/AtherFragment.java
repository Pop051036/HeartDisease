package com.example.nattapong.heartdisease.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nattapong.heartdisease.R;
import com.example.nattapong.heartdisease.dao.CommentCollDataDao;
import com.example.nattapong.heartdisease.dao.CommentInsertDao;
import com.example.nattapong.heartdisease.manager.HttpManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nuuneoi on 11/16/2014.
 */
@SuppressWarnings("unused")
public class AtherFragment extends Fragment implements View.OnClickListener {

    private Button btncomment;
    private EditText EditTextFeedbackBody;

    public AtherFragment() {
        super();
    }

    @SuppressWarnings("unused")
    public static AtherFragment newInstance() {
        AtherFragment fragment = new AtherFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_ather, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        // Init 'View' instance(s) with rootView.findViewById here
        EditTextFeedbackBody = (EditText) rootView.findViewById(R.id.EditTextFeedbackBody);
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
        if (v == btncomment){
            Call<CommentCollDataDao> call = HttpManager.getInstance().getService().commentuser("pop", EditTextFeedbackBody.getText().toString());
            call.enqueue(new Callback<CommentCollDataDao>() {
                @Override
                public void onResponse(Call<CommentCollDataDao> call, Response<CommentCollDataDao> response) {
                    if (response.isSuccessful()){
                        Log.e("atheruser", "แสดงความคิดเห็นสำเร็จ");
                    }else {
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
