package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String buscar(@PathParam("id") long id) {
		Carrinho carrinho = new CarrinhoDAO().busca(1l);
		return carrinho.toJSON();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar() {
		Carrinho carrinho = new CarrinhoDAO().busca(1l);
		return carrinho.toJSON();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public String adicionar(String conteudo) {
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		
		return "<sucess>sucesso</sucess>";
	}
}
