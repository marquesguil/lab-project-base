package com.labproject.base.services;

import com.labproject.base.domain.Categoria;
import com.labproject.base.exception.ObjectNotFoundException;
import com.labproject.base.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) throws ObjectNotFoundException {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria gravar(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }


}
