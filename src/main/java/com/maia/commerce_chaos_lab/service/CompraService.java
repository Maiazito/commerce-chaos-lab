package com.maia.commerce_chaos_lab.service;

import com.maia.commerce_chaos_lab.entity.Pedido;
import com.maia.commerce_chaos_lab.entity.Produto;
import com.maia.commerce_chaos_lab.repository.PedidoRepository;
import com.maia.commerce_chaos_lab.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class CompraService {

    private final ProdutoRepository produtoRepository;
    private final PedidoRepository pedidoRepository;

    public CompraService(
            ProdutoRepository produtoRepository,
            PedidoRepository pedidoRepository
    ) {
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public String comprar(Long produtoId) {

        try {

            Produto produto = produtoRepository.findById(produtoId)
                    .orElseThrow(() ->
                            new RuntimeException("Produto não encontrado")
                    );

            if (produto.getEstoque() <= 0) {
                return "Produto sem estoque";
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            produto.setEstoque(
                    produto.getEstoque() - 1
            );

            produtoRepository.save(produto);

            Pedido pedido = new Pedido();

            pedido.setValorTotal(produto.getPreco());

            pedido.setDataCriacao(LocalDateTime.now());

            pedido.setStatus("REALIZADO");

            pedidoRepository.save(pedido);

            return "Compra realizada com sucesso";

        } catch (ObjectOptimisticLockingFailureException e) {

            return "Outro usuário comprou este produto ao mesmo tempo";

        }
    }
}