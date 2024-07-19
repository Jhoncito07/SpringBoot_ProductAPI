package com.ejemplo.jpa_tutorial.service;

import com.ejemplo.jpa_tutorial.model.Producto;
import com.ejemplo.jpa_tutorial.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }

    public List<Producto> buscarProductosPorPrecio(Double precioMin, Double precioMax) {
        return productoRepository.findByPrecioBetween(precioMin, precioMax);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
