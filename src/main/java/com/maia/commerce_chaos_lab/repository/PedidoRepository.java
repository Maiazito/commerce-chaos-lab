package com.maia.commerce_chaos_lab.repository;


import com.maia.commerce_chaos_lab.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {
}
