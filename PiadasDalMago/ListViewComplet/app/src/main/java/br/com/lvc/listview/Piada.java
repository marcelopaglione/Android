package br.com.lvc.listview;

public class Piada {

	private String tituloPiada;
	private String imagePiada;
	private String rodapePiada;


	public Piada() {
	}

	public Piada(String tituloPiada, String imagePiada,String rodapePiada) {
		super();
		this.tituloPiada = tituloPiada;
		this.imagePiada = imagePiada;
		this.rodapePiada = rodapePiada;

	}

	public String getTituloPiada() {
		return tituloPiada;
	}

	public void setTituloPiada(String tituloPiada) {
		this.tituloPiada = tituloPiada;
	}

	public String getImagePiada() {
		return imagePiada;
	}

	public void setImagePiada(String imagePiada) {
		this.imagePiada = imagePiada;
	}

	public String getRodapePiada() {
		return rodapePiada;
	}

	public void setRodapePiada(String rodapePiada) {
		this.rodapePiada = rodapePiada;
	}

	@Override
	public String toString() {
		return tituloPiada;
	}
}