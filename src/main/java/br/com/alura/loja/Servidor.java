package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		// Configuração
		ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja");
		
		URI uri = URI.create("http://localhost:9999"); 	// Cria Endereço
		
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		
		System.out.println("Servidor rodando");
		
		// Aguardando espaço para finalizar servidor
		
		System.in.read();
		server.stop();
	}

}
