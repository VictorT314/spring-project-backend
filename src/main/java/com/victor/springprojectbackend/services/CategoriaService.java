package com.victor.springprojectbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.victor.springprojectbackend.domain.Categoria;
import com.victor.springprojectbackend.dto.CategoriaDTO;
import com.victor.springprojectbackend.repositories.CategoriaRepository;
import com.victor.springprojectbackend.services.exceptions.DataIntegrityException;
import com.victor.springprojectbackend.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	//INGESTÃO REPOSITORY
	@Autowired
	private CategoriaRepository repo;
	
	//FIND (GET_BY_ID)
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	
	//FIND_ALL (GET_ALL)
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	
	//INSERT (POST)
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	//UPDATE (PUT)
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	
	//DELETE (DELETE)
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	
	//FIND_PAGE (PAGINAÇÃO)
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	//FROM_DTO (CONVERSOR OBJ CATEGORIA_DTO -> CATEGORIA)
	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(), objDTO.getNome());
	}
}