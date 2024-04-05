package model;


public class Carro {
	private int codigo;
	private String modelo;
	private int ano;
	private String marca;
	private int quilometragem;
	
	public Carro() {
		this.codigo = -1;
		this.modelo = "";
		this.ano = -1;
		this.marca = "";
		this.quilometragem = -1;
	}

	public Carro(int codigo, String modelo, int ano, String marca, int quilometragem) {
		this.codigo = codigo;
		this.modelo = modelo;
		this.ano = ano;
		this.marca = marca;
		this.quilometragem = quilometragem;
	}		
	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getQuilometragem() {
		return this.quilometragem;
	}

	public void setQuilometragem(int quilometragem) {
		 this.quilometragem = quilometragem;
	}

	public void printScreen(){
		System.out.println("Codigo: "+ this.codigo + " Modelo: "+ this.modelo + " Marca: "+ this.marca + " Ano: " + this.ano + " Quilometragem: "+ this.quilometragem);
	}

}