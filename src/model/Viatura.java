package model;

import java.sql.Date;

public class Viatura {
	private Long cod;
	private String nome;
	private String marca;
	private Date fabrico;
	private Long tipo;
	private String tipoDesc;
	
	public String getTipoDesc() {
		return tipoDesc;
	}
	public void setTipoDesc(String tipoDesc) {
		this.tipoDesc = tipoDesc;
	}
	public Viatura(Long cod, String nome, String marca, Date fabrico, String tipoDesc) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.marca = marca;
		this.fabrico = fabrico;
		this.tipoDesc = tipoDesc;
	}
	public Viatura(Long cod, String nome, String marca, Date fabrico, Long tipo) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.marca = marca;
		this.fabrico = fabrico;
		this.tipo = tipo;
	}
	public Viatura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setFabrico(Date fabrico) {
		this.fabrico = fabrico;
	}
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public Long getTipo() {
		return tipo;
	}
	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public String getMarca() {
		return marca;
	}
	public Date getFabrico() {
		return fabrico;
	}
	@Override
	public String toString() {
		return "Viatura [cod=" + cod + ", nome=" + nome + ", marca=" + marca + ", fabrico=" + fabrico + ", tipo=" + tipo
				+ "]";
	}
	
	
}
