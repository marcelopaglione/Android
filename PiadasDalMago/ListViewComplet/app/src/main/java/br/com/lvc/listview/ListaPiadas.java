package br.com.lvc.listview;

import java.util.List;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.lvc.listview.downloadImages.ImageLoader;

import static br.com.lvc.listview.R.raw.risada;

public class ListaPiadas extends ArrayAdapter<Piada> {

	private Context context;
	private List<Piada> piadas = null;
	private ImageLoader imgLoader;

	public ListaPiadas(Context context, List<Piada> piadas) {
		super(context, 0, piadas);
		this.piadas = piadas;
		this.context = context;
		imgLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		Piada piada = piadas.get(position);

		view = LayoutInflater.from(context).inflate(R.layout.item_list_piadas, null);

		//new DownloadImage((ImageView) view.findViewById(R.id.imagem)).execute(piada.getImagePiada());
		ImageView imgView = (ImageView)view.findViewById(R.id.imagem);
		imgLoader.DisplayImage(piada.getImagePiada(), imgView);
		imgView.setOnClickListener(onClick);
		
		TextView textViewNomeZombie = (TextView) view.findViewById(R.id.titulo);
		textViewNomeZombie.setText(piada.getTituloPiada());
		
		TextView rodape = (TextView)view.findViewById(R.id.rodape);
		String rodape2 = String.valueOf(piada.getRodapePiada());
		rodape.setText(rodape2);

		return view;
	}

	View.OnClickListener onClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			MediaPlayer mp = MediaPlayer.create(context, risada);
			mp.start();
			mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
				@Override
				public void onCompletion(MediaPlayer mp) {
					if (mp != null) {
						mp.release();
						mp = null;
					}
				}
			});
		}

	};

}