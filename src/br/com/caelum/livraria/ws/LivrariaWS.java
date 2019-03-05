package br.com.caelum.livraria.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@Stateless
@WebService
public class LivrariaWS {
	
	@Inject
	private LivroDao livroDao;

	@WebResult(name="autores")
	public List<Livro> getLivros(@WebParam(name="titulo") String nome) {
		System.out.println("LivrariaWS: procurando pelo nome" + nome);
		return livroDao.getLivroPorNome(nome);
	}
}
