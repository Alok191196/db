package com.example.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.model.WorkName;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_TASK_DESC = "key_task_desc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data data = new Data.Builder()
                .putString(KEY_TASK_DESC, "Hey I'm sending the work data")
                .build();


        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .build();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WorkManager.getInstance().enqueue(request);
            }
        });

        final TextView textView = findViewById(R.id.textView);
        WorkManager.getInstance().getWorkInfoByIdLiveData(request.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        if(workInfo != null) {
                            if(workInfo.getState().isFinished()){
                                Data data = workInfo.getOutputData();
                                String output = data.getString(MyWorker.KEY_TASK_OUTPUT);
                                textView.append(output + "\n");
                            }
                            String status = workInfo.getState().name();
                            textView.append(status + "\n");
                        }
                    }
                });

    }
}
