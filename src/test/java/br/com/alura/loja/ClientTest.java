package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import junit.framework.Assert;

public class ClientTest {
	
	@Test
	public void testaQueAConexaoComOServidorFuncionou() {
		
		Client client = ClientBuilder.newClient();	// Cria cliente
		WebTarget target = client.target("http://www.mocky.io");	// Defini o alvo (URI)
		
		String  conteudo = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
		
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("<rua>Rua Vergueiro 3185"));
		
	}

}
