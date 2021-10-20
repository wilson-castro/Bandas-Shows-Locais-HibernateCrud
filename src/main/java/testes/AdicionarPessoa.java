package testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class AdicionarPessoa {
	public static void main(String[] args) {
			Pessoa pessoa  = new Pessoa();
			pessoa.setEmail("pessoa@gmail.com");
			pessoa.setNome("Pessoa da Costa");
			
		    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoas");
		    EntityManager em = emf.createEntityManager();

		    em.getTransaction().begin();
		    em.persist(pessoa);
		    em.getTransaction().commit();

		    em.close();
		    emf.close();
	}
}
