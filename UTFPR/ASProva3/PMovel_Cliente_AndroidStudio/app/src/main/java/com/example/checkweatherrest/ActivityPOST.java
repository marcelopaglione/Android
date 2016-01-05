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
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */
public class ActivityPOST extends ActionBarActivity {

    EditText et1,et2,et3;
    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_post);

        tv = (TextView) findViewById(R.id.textView5);
        tv.setText("");
        et1 = (EditText) findViewById(R.id.editText2);
        et2 = (EditText) findViewById(R.id.editText3);
        et3 = (EditText) findViewById(R.id.editText4);
        bt = (Button) findViewById(R.id.button6);
        bt.setOnClickListener(bt_clicado);

    }

    private View.OnClickListener bt_clicado = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String resourceURL = "http://10.0.2.2:4000/tasks";
            AsyncHttpClient httpClient = new AsyncHttpClient();

            JSONObject params = new JSONObject();
            try {
                params.put("id", Integer.parseInt(et1.getEditableText().toString()));
                params.put("nome", et2.getEditableText().toString());
                params.put("descricao", et3.getEditableText().toString());
                params.put("status", "ABERTA");
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            StringEntity entity = null;
            try {
                entity = new StringEntity(params.toString());
                entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            httpClient.post(ActivityPOST.this, resourceURL, entity, "application/json",
                    new JsonHttpResponseHandler() {
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            tv.setText("Sucesso! " + response.toString());
                        };
                        public void onFailure(int statusCode, Header[] headers, String responseString,
                                              Throwable throwable) {
                            tv.setText("Falha! " + responseString);
                        }
                    });
        }
    };

}
