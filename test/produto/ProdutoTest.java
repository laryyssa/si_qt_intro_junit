package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdu��o ao Teste de Software", 100.00);
	}
	
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdu��o ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
	}
	
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdu��o ao Teste de Software", 90.00);
		
		assertNotSame(livro, livro2);
		
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}
	
	@Test
	public void testProdutoIgual() {
		livro = new Produto("Programação 1", 100.00);
		boolean resultado = livro.equals(livro);
		
		Assertions.assertEquals(true, resultado);				
		
	}
	
	@Test
	public void testProdutoDiferente() {
	    Produto livroP1 = new Produto("Programação 1", 100.00);
	    Produto livroP2 = new Produto("Programação 2", 200.00);
	    boolean resultado = livroP1.equals(livroP2);
	    
	    Assertions.assertEquals(false, resultado, "Produtos com nomes diferentes devem ser considerados diferentes.");
	}

	
	@Test
	public void testAlteraPreco() {
	    livro.setPreco(120.00);
	    assertEquals(120.00, livro.getPreco());
	}

}
