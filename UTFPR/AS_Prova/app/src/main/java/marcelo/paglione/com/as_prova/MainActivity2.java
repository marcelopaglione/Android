package marcelo.paglione.com.as_prova;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button buttonMeuNome,buttonVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonMeuNome = (Button)findViewById(R.id.buttonMeuNome);
        buttonMeuNome.setOnClickListener(buttonMeuNomeClicado);
        buttonVoltar = (Button)findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(buttonVoltarClicado);
    }

    private OnClickListener buttonMeuNomeClicado = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity2.this,"Marcelo Paglione",Toast.LENGTH_SHORT).show();
        }
    };

    private OnClickListener buttonVoltarClicado = new OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity2.this);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setTitle("Alerta!");
            alertDialogBuilder.setMessage("Vai voltar?");
            alertDialogBuilder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity2.this.finish();
                }
            });
            alertDialogBuilder.setNegativeButton("Não",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = alertDialogBuilder.create();
            dialog.show();
        }
    };


}
