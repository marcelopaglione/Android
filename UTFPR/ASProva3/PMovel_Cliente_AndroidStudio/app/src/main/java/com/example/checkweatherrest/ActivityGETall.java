package com.example.checkweatherrest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */
public class ActivityGETall extends ActionBarActivity {

    ArrayAdapter<Task> taskArrayAdapter;
    List<Task> taskList;
    ListView listView;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_getall);
        taskList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        taskArrayAdapter = new ArrayAdapter<>(ActivityGETall.this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(taskArrayAdapter);
        bt = (Button)findViewById(R.id.button8);
        bt.setOnClickListener(bt_clicado);
        updateListView();
    }

    private View.OnClickListener bt_clicado = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            taskArrayAdapter.clear();
            updateListView();
        }
    };

    private void updateListView() {
        String resourceURL = "http://10.0.2.2:4000/tasks";
        AsyncHttpClient httpClient = new AsyncHttpClient();

        httpClient.get(resourceURL, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        Task c = new Task(obj.getInt("id"), obj.getString("nome"), obj.getString("descricao"),obj.getString("status"));
                        taskList.add(c);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                taskArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
