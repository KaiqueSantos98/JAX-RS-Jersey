package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import junit.framework.Assert;

public class ClientTest {
	
	private HttpServer server;
	
	@Before
	public void startaServidor() {
		server = Servidor.inicializaServidor();
		System.out.println("Servidor inicializado!");
	}
	
	@After
	public void desligaServidor() {
		server.stop();
		System.out.println("Servidor Encerrado!");
	}
	
	@Test
	public void testaQueAConexaoComOServidorFuncionou() {
		
		Client client = ClientBuilder.newClient();	// Cria cliente
		WebTarget target = client.target("http://localhost:9191");	// Defini o alvo (URI)

		String  conteudo = target.path("/carrinhos").request().get(String.class);
		
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
		
	}

}
