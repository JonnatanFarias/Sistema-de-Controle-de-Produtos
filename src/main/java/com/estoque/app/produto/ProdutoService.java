package com.estoque.app.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> buscardPorId(Integer id) {
		return produtoRepository.findById(id);
	}

	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto atualizarParcial(Integer id, Produto dadosParciais) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

		if (dadosParciais.getDescricao() != null) {
			produto.setDescricao(dadosParciais.getDescricao());
		}

		if (dadosParciais.getNome() != null) {
			produto.setNome(dadosParciais.getNome());
		}
		if (dadosParciais.getQuantidade() != null) {
			produto.setQuantidade(dadosParciais.getQuantidade());
		}

		return produtoRepository.save(produto);
	}

	public void deletar(Integer id) {
		produtoRepository.deleteById(id);
	}

}
