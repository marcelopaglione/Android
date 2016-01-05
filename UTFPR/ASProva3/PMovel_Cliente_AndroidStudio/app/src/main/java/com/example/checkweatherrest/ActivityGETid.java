package com.example.checkweatherrest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;
/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */
public class ActivityGETid extends ActionBarActivity {

    EditText et;
    TextView tv1,tv2,tv3,tv4;
    Button bt;
    String resourceURL;
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_getid);
        et = (EditText) findViewById(R.id.editText);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        bt = (Button) findViewById(R.id.button5);
        bt.setOnClickListener(bt_clicado);
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");

    }

    private View.OnClickListener bt_clicado = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resourceURL = "http://10.0.2.2:4000/tasks/" + et.getEditableText().toString();
            AsyncHttpClient httpClient = new AsyncHttpClient();
            httpClient.get(resourceURL, new JsonHttpResponseHandler() {
                public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                    try {
                        json = jsonObject.toString();
                        tv3.setText(json);

                        String id = jsonObject.getString("id");
                        String nome = jsonObject.getString("nome");
                        String descricao = jsonObject.getString("descricao");
                        String status = jsonObject.getString("status");

                        tv1.setText("Id: " + id);
                        tv2.setText("Task: " + nome);
                        tv3.setText("Descrição:" + descricao);
                        tv4.setText("Status: " + status);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    tv1.setText("Error accessing website");
                    tv2.setText(resourceURL);
                    tv3.setText(json);
                }
            });
        }
    };

}
