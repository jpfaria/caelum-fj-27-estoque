package br.com.caelum.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.estoque.Movimentacao;
import br.com.caelum.estoque.Produto;
import br.com.caelum.estoque.dao.MovimentacaoDAO;
import br.com.caelum.estoque.dao.ProdutoDAO;
import br.com.caelum.estoque.service.GeradorDeMovimentacao;

//@Scope("request") // processa a todo request
@Controller
@RequestMapping(value="/produtos")
public class ProdutosController {

	@Autowired
	//@Qualifier("produtoHibernateDAO") // modifica implementacao padrao
	private ProdutoDAO produtoDAO;
	
	@Autowired
	private GeradorDeMovimentacao geradorDeMovimentacao;
	
	@Autowired
	private MovimentacaoDAO movimentacaoDAO;
	
	ProdutosController() {
		//System.out.println("echo aqui");
	}
	
	@RequestMapping("/index")
	public String index() {
		return "produtos/index";
	}
	
	@RequestMapping(value="/listar", method={ RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("produtos/listar");
		modelAndView.addObject(produtoDAO.listar());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/mostrar/{id}", method=RequestMethod.GET)
	public ModelAndView mostrar(@PathVariable("id") Long id) {
		
		/*
		Produto produto = produtoDAO.buscarPorId(id);
		List<Movimentacao> movimentacoes = produto.getMovimentacoes();
		movimentacoes.size();
		*/
		
		ModelAndView modelAndView = new ModelAndView("produtos/mostrar");
		modelAndView.addObject(produtoDAO.buscarPorId(id));
		//modelAndView.addObject(movimentacoes);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		return "produtos/form";
	}
	
	@RequestMapping(value="/alterar", method=RequestMethod.POST)
	@Transactional
	public String alterar(Produto produto) {
		
		Movimentacao movimentacao = geradorDeMovimentacao.geraMovimentacao(produto);
		movimentacaoDAO.salvar(movimentacao);
		produtoDAO.alterar(produto);
		return "redirect:/produtos/listar";
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("produtos/editar");
		modelAndView.addObject(produtoDAO.buscarPorId(id));
		
		return modelAndView;
	}
	
	@RequestMapping(value="/remover/{id}", method=RequestMethod.GET)
	public String remover(@PathVariable("id") Long id) {
		Produto produto = produtoDAO.buscarPorId(id);
		produtoDAO.remover(produto);
		return "redirect:/produtos/listar";
	}
	
	/* forma bacalhau
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String salvar(Produto produto) {
		dao.salvar(produto);
		return "forward:/produtos/listar";
	}
	*/
	
	/* forma correta */
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public String salvar(Produto produto, RedirectAttributes ra) {
		produtoDAO.salvar(produto);
		ra.addFlashAttribute("mensagem", "produto inserido com sucesso");
		return "redirect:/produtos/listar";
	}
	
	
}
