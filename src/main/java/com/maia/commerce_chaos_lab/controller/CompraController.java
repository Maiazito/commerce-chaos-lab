package com.maia.commerce_chaos_lab.controller;


import com.maia.commerce_chaos_lab.service.CompraService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/comprar")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/{id}")
    public String comprar(@PathVariable long id){
        return compraService.comprar(id);
    }
}
