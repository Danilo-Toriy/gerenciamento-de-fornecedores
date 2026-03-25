package com.example.danilo.controller;

import com.example.danilo.entity.Fornecedor;
import com.example.danilo.service.FornecedorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> save(@RequestBody Fornecedor novoFornecedor){
        Fornecedor fornecedor = fornecedorService.save(novoFornecedor);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll(){
        List<Fornecedor> fornecedorList = fornecedorService.findAll();
        return fornecedorList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(fornecedorList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id){
        Optional<Fornecedor> fornecedorAchado = fornecedorService.findById(id);
        return fornecedorAchado.isPresent()
                ? ResponseEntity.ok().body(fornecedorAchado.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedorAtualizado){
        Fornecedor fornecedor = fornecedorService.update(id, fornecedorAtualizado);
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        fornecedorService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
