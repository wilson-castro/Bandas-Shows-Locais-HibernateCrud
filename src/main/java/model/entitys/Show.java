package model.entitys;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="showID")
	private Long id;
	
	@Column(name="data_do_show", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id", referencedColumnName="LocalID")
	private Local local_do_show;
	
	@ManyToMany(mappedBy = "shows")
	private List<Banda> bandas;
	
	public Show() {
		
	}
	
	public Show(Long id, Calendar data, Local local_do_show) {
		super();
		this.id = id;
		this.data = data;
		this.local_do_show = local_do_show;
	}

	public Show(Long id, Calendar data, Local local_do_show, List<Banda> bandas) {
		super();
		this.id = id;
		this.data = data;
		this.local_do_show = local_do_show;
		this.bandas = bandas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Local getLocal_do_show() {
		return local_do_show;
	}

	public void setLocal_do_show(Local local_do_show) {
		this.local_do_show = local_do_show;
	}

	public List<Banda> getBandas() {
		return bandas;
	}

	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}

	
	
}
