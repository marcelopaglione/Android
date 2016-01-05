package com.example.checkweatherrest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */

public class ActivityDELETE extends ActionBarActivity {

    EditText et;
    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_delete);
        et = (EditText) findViewById(R.id.editText5);
        tv = (TextView) findViewById(R.id.textView6);
        bt = (Button) findViewById(R.id.button7);
        bt.setOnClickListener(bt_clicado);
        tv.setText("");
    }

    private View.OnClickListener bt_clicado = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String resourceURL = "http://10.0.2.2:4000/tasks/"+et.getEditableText().toString();

            AsyncHttpClient httpClient = new AsyncHttpClient();
            httpClient.delete(resourceURL, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                    tv.setText("falha! "+s);
                }

                @Override
                public void onSuccess(int i, Header[] headers, String s) {
                    if(!s.contains("\"id\":0,\"nome\":\"\",\"descricao\":\"\",\"status\":\"ABERTA\"")) {
                        tv.setText("Sucesso!\n" + s + "\nRemovido");
                    }
                    else{
                        tv.setText("Id inexistente!");
                    }
                }
            });
        }
    };

}
