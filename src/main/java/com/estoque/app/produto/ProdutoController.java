package com.estoque.app.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> listarTodos() {
		return produtoService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {

		Optional<Produto> produto = produtoService.buscardPorId(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
		Produto novoProduto = produtoService.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Produto> atualizarParcial(@PathVariable Integer id, @RequestBody Produto produtoParcial) {
		try {
			Produto produtoAtualizado = produtoService.atualizarParcial(id, produtoParcial);
			return ResponseEntity.ok(produtoAtualizado);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
