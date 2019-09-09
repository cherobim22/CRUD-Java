package model.bean;

public class beanprodutos {
	public int idproduto;
	private String Nome;
	private String Valor;
	private String Unidade;
	
	
	public int getId() {
		return idproduto;
	}
	public void setId(int idproduto) {
		this.idproduto = idproduto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getValor() {
		return Valor;
	}
	public void setValor(String valor) {
		Valor = valor;
	}
	public String getUnidade() {
		return Unidade;
	}
	public void setUnidade(String unidade) {
		Unidade = unidade;
	}
	
}
