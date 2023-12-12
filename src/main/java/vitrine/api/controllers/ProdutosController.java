package vitrine.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitrine.api.classes.produto;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    // Simulação de dados, substitua por lógica de serviço real
    private static final List<produto> listaDeProdutos = Arrays.asList(
            new produto(1L, "https://fiozato.com/products/vestido-lonely?variant=43866897776893&pp=0", "VESTIDO LONELY", "tamanho P M G cor rosa e azul", 10),
            new produto(2L, "https://br.pinterest.com/pin/1044905551019057607/", "Vestido Drapeado Liso Casual", "tamanho P M G cor preto e amarelo", 20),
            new produto(3L, "https://br.pinterest.com/pin/33706697204991224/", "Vestidos glamourosos", "tamanho P M G cor preto e vermelho", 15),
            new produto(4L, "https://br.pinterest.com/pin/578712620895368402/", "Vestido de dama de honra chiffon de renda", "tamanho P M G cor verde e azul", 8),
            new produto(5L, "https://fiozato.com/products/vestido-abyssal?variant=44140597444861&pp=0", "VESTIDO ABYSSAL", "tamanho P M G cor preto ", 22)
    );


    @GetMapping
    public List<produto> listarProdutos() {
        // Retorna a lista de produtos com apenas os campos necessários
        return listaDeProdutos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<produto> detalharProduto(@PathVariable Long id) {
        // Lógica para encontrar o produto com base no ID
        produto produtoEncontrado = listaDeProdutos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (produtoEncontrado != null) {
            return ResponseEntity.ok(produtoEncontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




