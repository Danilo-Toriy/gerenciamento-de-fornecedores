package com.example.danilo.service;

import com.example.danilo.entity.Fornecedor;
import com.example.danilo.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(Long id){
        return fornecedorRepository.findById(id);
    }

    public Fornecedor save(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public void deleteById(Long id){
        fornecedorRepository.deleteById(id);
    }

    public Fornecedor update(Long id, Fornecedor fornecedor){
        Fornecedor novoFornecedor = fornecedorRepository.findById(id).get();

        novoFornecedor.setNomeFantasia(fornecedor.getNomeFantasia());
        novoFornecedor.setCnpj(fornecedor.getCnpj());
        novoFornecedor.setContato(fornecedor.getContato());

        return fornecedorRepository.save(novoFornecedor);
    }
}
