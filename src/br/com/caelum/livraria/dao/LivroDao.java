package br.com.caelum.livraria.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return manager.createQuery("select a from Livro a", Livro.class).getResultList();
	}
	
	public Livro buscaPelaId(Integer idLivro) {
		Livro livro = this.manager.find(Livro.class, idLivro);
		return livro;
	}
	
}
