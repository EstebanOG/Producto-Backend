package com.tinguiclick.producto.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tinguiclick.producto.model.Producto;
import com.tinguiclick.producto.repository.ProductoRepository;

@Service
public class ProductoService{
	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public Producto getById(Long id) {
		return productoRepository.getById(id);
	}

	public <S extends Producto> S save(S entity) {
		return productoRepository.save(entity);
	}

	public void deleteById(Long id) {
		productoRepository.deleteById(id);
		
	}
	
	public List<Producto> findAll(Sort sort) {
		return productoRepository.findAll(sort);
	}

	public void delete(Producto entity) {
		productoRepository.delete(entity);
		
	}

	public Page<Producto> findAll(Pageable pageable) {
		return productoRepository.findAll(pageable);
	}

	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
	}

}
