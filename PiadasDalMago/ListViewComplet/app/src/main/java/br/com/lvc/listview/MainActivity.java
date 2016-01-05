package br.com.lvc.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		List<Piada> piadas = gerarPiadas();
		
		ListaPiadas listaPiadas = new ListaPiadas(this,  piadas);
		setListAdapter(listaPiadas);
	}
	
	private List<Piada> gerarPiadas() {
		List<Piada> piadas = new ArrayList<Piada>();
		piadas.add(criarPiada("Porque piada ruim é aqui mesmo","",""));

		piadas.add(criarPiada("Ba dum tsss",
				"http://2.bp.blogspot.com/-CpqjOqp_jDY/VHE8PirVmzI/AAAAAAAAD9w/mc5Fb-Ty8K0/s1600/IMG_20141005_191614540.jpg",
				"Postado há 22nd November 2014 por Matheus"));

		piadas.add(criarPiada("Ok, essa foi muito ruim",
				"http://4.bp.blogspot.com/-fOTHNfjXSyg/VHE7ZM68TMI/AAAAAAAAD9o/2qdeRafAW_k/s1600/IMG_20140930_094338187_HDR.jpg",
				"Postado há 22nd November 2014 por Matheus"));

		piadas.add(criarPiada("Just saw on the internet\nI totally agree",
				"http://1.bp.blogspot.com/-AQTW6_WALtY/VGv5HkudqJI/AAAAAAAABmo/_WV7X02gG5g/s1600/10355810_745601782203383_7747267702853080372_n.jpg",
				"Postado há 18th November 2014 por Matheus"));

		piadas.add(criarPiada("Well done\nTraduções boas: pilot",
				"http://4.bp.blogspot.com/-NiXq3um6SFY/VGlSnwPFXPI/AAAAAAAABmU/UwJXQAAEHbM/s1600/49097511.jpg",
				"Postado há 16th November 2014 por Matheus"));

		piadas.add(criarPiada("Estrela pila\nSó piada boa!",
				"http://2.bp.blogspot.com/-zfimfqp2sEs/VGj9YgIACpI/AAAAAAAABkc/hnMStKKLXhU/s1600/unnamed.png",
				"Postado há 16th November 2014 por Matheus"));

		piadas.add(criarPiada("Santa ovelha!",
				"http://3.bp.blogspot.com/-prgEtOCwg_o/VGj7fvtSuUI/AAAAAAAABkQ/0NR3cs3qstE/s1600/2011-04-14-HOLY-SHIT.jpg",
				"Postado há 16th November 2014 por Matheus"));

		piadas.add(criarPiada("9gag made me laugh",
				"http://4.bp.blogspot.com/-WKIZlEjK4Hs/VGe60lQ2tmI/AAAAAAAABh8/_ff3_5rssI4/s1600/93c272580b7697344f2467c8bcdda89cae88a69bb010f2e874e7c3f507949e16.jpg",
				"Postado há 15th November 2014 por Matheus"));


		return piadas;
	}
	
	private Piada criarPiada(String titulo, String imagem, String rodape) {
		Piada piada = new Piada(titulo, imagem,rodape);
		return piada;
	}
}