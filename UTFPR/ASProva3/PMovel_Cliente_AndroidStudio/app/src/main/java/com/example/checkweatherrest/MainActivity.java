package com.example.checkweatherrest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/*
 * Marcelo Ortiz Paglione Junior
 * RA: 1256300
 */
public class MainActivity extends Activity {
	Button bt1,bt2,bt3,bt4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt1 = (Button) findViewById(R.id.button);
		bt2 = (Button) findViewById(R.id.button2);
		bt3 = (Button) findViewById(R.id.button3);
		bt4 = (Button) findViewById(R.id.button4);

		bt1.setOnClickListener(bt_clicado);
		bt2.setOnClickListener(bt_clicado);
		bt3.setOnClickListener(bt_clicado);
		bt4.setOnClickListener(bt_clicado);
	}

	private OnClickListener bt_clicado = new OnClickListener() {
		@Override
		public void onClick(View v){
			Intent i;
			switch (v.getId()){
				case R.id.button:
					i = new Intent(MainActivity.this,ActivityGETall.class);
					startActivity(i);
					break;

				case R.id.button2:
					i = new Intent(MainActivity.this,ActivityGETid.class);
					startActivity(i);
					break;

				case R.id.button3:
					i = new Intent(MainActivity.this,ActivityPOST.class);
					startActivity(i);
					break;

				case R.id.button4:
					i = new Intent(MainActivity.this,ActivityDELETE.class);
					startActivity(i);
					break;
			}
		}
	};

}