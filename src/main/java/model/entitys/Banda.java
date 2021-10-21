package model.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import model.enums.Genero;
import utils.BaseBean;

@Entity
@Table(name="bandas")
public class Banda implements BaseBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bandaID")
	private Long id;
	
	@Column(name="nome", nullable = false)
	private String nome;
	
	@Column(name="genero",  nullable=false)
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	public Banda() {
		
	}

	public Banda(Long id, String nome, Genero genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
