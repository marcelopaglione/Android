package marcelo.paglione.com.as_prova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int TASK_ADD_CODE = 42;
    Button buttonQ2, buttonQ3;

    TextView nome1,grupo1,regiao1,cuidado1,telefone1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonQ2 = (Button)findViewById(R.id.buttonQ2);
        buttonQ2.setOnClickListener(botao2Clicado);
        buttonQ3 = (Button)findViewById(R.id.buttonQ3);
        buttonQ3.setOnClickListener(botao3Clicado);

        nome1 = (TextView)findViewById(R.id.textViewN);
        grupo1 = (TextView)findViewById(R.id.textViewG);
        regiao1 = (TextView)findViewById(R.id.textViewR);
        cuidado1 = (TextView)findViewById(R.id.textViewC);
        telefone1 = (TextView)findViewById(R.id.textViewT);
    }

    private OnClickListener botao2Clicado = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);
        }
    };

    private OnClickListener botao3Clicado = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, MainActivity3.class);
            startActivityForResult(i, TASK_ADD_CODE);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TASK_ADD_CODE && resultCode == RESULT_OK) {
            Contato contato = (Contato) data.getSerializableExtra("contatoAdded");
            nome1.setText("Nome contato: "+contato.getNomeContato());
            if (!contato.getGrupo().equals(""))
                grupo1.setText("Grupo: "+contato.getGrupo());
            else{
                grupo1.setText("Grupo: Não informado");
            }
            regiao1.setText("Região: "+contato.getRegiao());
            cuidado1.setText("Cuidado Especial?: "+String.valueOf(contato.getCuidadoEspecial()));
            if (contato.cuidadoEspecial==true){
                telefone1.setText("Telefone: "+contato.getTelefoneContato());
            }
            else{
                telefone1.setText(contato.getTelefoneContato());
            }
        }
    }

}
