package marcelo.paglione.com.as_prova;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {
    Spinner regioes;
    EditText nomeContato,telefoneContato;
    RadioButton familiar,trabalho,amigo;
    CheckBox cuidadoEspecial;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        regioes = (Spinner) findViewById(R.id.spinner);
        nomeContato = (EditText)findViewById(R.id.editTextNomeDoContato);
        telefoneContato = (EditText)findViewById(R.id.editTextCuidadoEspecial);
        familiar = (RadioButton)findViewById(R.id.radioButtonFamiliar);
        trabalho = (RadioButton)findViewById(R.id.radioButtonTrabalho);
        amigo = (RadioButton)findViewById(R.id.radioButtonAmigo);
        cuidadoEspecial = (CheckBox)findViewById(R.id.checkBoxCuidadoEspecial);
        salvar = (Button)findViewById(R.id.buttonSalvar);
        salvar.setOnClickListener(botaoSalvarClicado);

        ArrayAdapter<CharSequence> regAdapter = ArrayAdapter.createFromResource(this,
                R.array.regiao_estados, android.R.layout.simple_spinner_item);
        regioes.setAdapter(regAdapter);
    }

    private OnClickListener botaoSalvarClicado = new OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity3.this);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setTitle("Alerta!");
            alertDialogBuilder.setMessage("Dados faltantes");
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = alertDialogBuilder.create();
            if (!nomeContato.getEditableText().toString().equals("")){
                if(!regioes.getSelectedItem().toString().equals("--")){
                    if (cuidadoEspecial.isChecked()){
                        if (!telefoneContato.getEditableText().toString().equals("")){

                            String nome = nomeContato.getEditableText().toString();
                            String grupo = "";
                            if(familiar.isChecked()){
                                grupo = familiar.getText().toString();
                            }
                            else if(trabalho.isChecked()){
                                grupo = trabalho.getText().toString();
                            }
                            else if(amigo.isChecked()){
                                grupo = amigo.getText().toString();
                            }
                            String regi = regioes.getSelectedItem().toString();
                            String telefone = telefoneContato.getEditableText().toString();

                            Contato contato= new Contato(nome,grupo,regi,true,telefone);
                            Intent i = new Intent();
                            i.putExtra("contatoAdded", contato);
                            setResult(RESULT_OK, i);
                            MainActivity3.this.finish();

                        }else{
                            dialog.setMessage("Informe um telefone para contato");
                            dialog.show();
                        }
                    }else{
                        String nome = nomeContato.getEditableText().toString();
                        String grupo = "";
                        if(familiar.isChecked()){
                            grupo = familiar.getText().toString();
                        }
                        else if(trabalho.isChecked()){
                            grupo = trabalho.getText().toString();
                        }
                        else if(amigo.isChecked()){
                            grupo = amigo.getText().toString();
                        }
                        String regi = regioes.getSelectedItem().toString();
                        String telefone = "";

                        Contato contato= new Contato(nome,grupo,regi,false,telefone);
                        Intent i = new Intent();
                        i.putExtra("contatoAdded", contato);
                        setResult(RESULT_OK, i);
                        MainActivity3.this.finish();
                    }
                }else{
                    dialog.setMessage("Escolha uma região");
                    dialog.show();
                }
            }else{
                dialog.setMessage("Preencher nome para contato");
                dialog.show();
            }
        }
    };


}
