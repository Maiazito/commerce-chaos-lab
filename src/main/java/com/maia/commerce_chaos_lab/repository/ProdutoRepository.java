package com.maia.commerce_chaos_lab.repository;

import com.maia.commerce_chaos_lab.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
}
