package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext contex) throws Exception {

		long millis = System.currentTimeMillis();

		Object o = contex.proceed();
		String nomeMetodo = contex.getMethod().getName();
		String nomeClasse = contex.getTarget().getClass().getName();
		
		System.out.println("Classe: "+ nomeClasse + "Método: "+ nomeMetodo);
		System.out.println("[INFO] Tempo gasto no acesso ao BD: " + (System.currentTimeMillis() - millis) + "ms");

		return o;

	}
}
