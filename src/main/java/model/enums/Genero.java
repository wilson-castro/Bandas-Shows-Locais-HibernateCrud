package model.enums;

public enum Genero {
	ROCK("ROCK"), AXE("AXÉ"), FORRO("FORRÓ");
	
	private String descricao;

	Genero(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
