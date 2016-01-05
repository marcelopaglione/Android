package marcelo.paglione.com.as_prova;

import java.io.Serializable;
/**
 * Created by marcelopaglione on 9/18/15.
 */
public class Contato implements Serializable {
    String nomeContato;
    String grupo;
    String regiao;
    boolean cuidadoEspecial;
    String telefoneContato;

    Contato(String nomeContato,String grupo,String regiao, boolean cuidadoEspecial, String telefoneContato){
        this.nomeContato = nomeContato;
        this.grupo = grupo;
        this.regiao = regiao;
        this.cuidadoEspecial = cuidadoEspecial;
        this.telefoneContato = telefoneContato;
    }

    public String getNomeContato(){
        return nomeContato;
    }

    public String getGrupo(){
        return grupo;
    }

    public String getRegiao(){
        return regiao;
    }

    public boolean getCuidadoEspecial(){
        return cuidadoEspecial;
    }
    public String getTelefoneContato(){
        return telefoneContato;
    }
}
