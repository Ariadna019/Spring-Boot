package com.mtw.logeoregistrar.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtw.logeoregistrar.Models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

