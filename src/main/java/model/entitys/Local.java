package model.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import utils.BaseBean;

@Entity
@Table(name="locais")
public class Local implements BaseBean {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LocalID")
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int capacidade;
	
	@OneToMany( 
		mappedBy="local_do_show" ,
	    fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<Show> shows;
	
	public Local() {
		
	}

	public Local(Long id, String nome, int capacidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
	}

	public Local(Long id, String nome, int capacidade, List<Show> shows) {
		super();
		this.id = id;
		this.nome = nome;
		this.capacidade = capacidade;
		this.shows = shows;
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

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	
}
