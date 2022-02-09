package com.tinguiclick.producto.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinguiclick.producto.model.Producto;
import com.tinguiclick.producto.service.ProductoService;

@RestController
@RequestMapping("/productos/")
public class ProductoRest {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	private ResponseEntity<List<Producto>> getAllProductos(){
		return ResponseEntity.ok(productoService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Producto> saveProducto(@RequestBody Producto producto){
		Producto productoGuardado = productoService.save(producto);
		try {
			return ResponseEntity.created(new URI("/productos/"+productoGuardado.getCodigo())).body(productoGuardado);
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteProducto(@PathVariable("id") Long idProducto){
		productoService.deleteById(idProducto);
		return ResponseEntity.ok(!(productoService.findById(idProducto) != null));
	}
}
