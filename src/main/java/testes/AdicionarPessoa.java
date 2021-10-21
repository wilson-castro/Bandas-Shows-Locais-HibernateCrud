package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.Pessoa;

public class AdicionarPessoa {
	public static void main(String[] args) {
			Pessoa pessoa  = new Pessoa();
			pessoa.setEmail("coisa@gmail.com");
			pessoa.setNome("Coisa da Costa");
			
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto_JPA");
		    EntityManager em = emf.createEntityManager();

		    em.getTransaction().begin();
		    em.persist(pessoa);
		    em.getTransaction().commit();

		    em.close();
		    emf.close();
	}
}
