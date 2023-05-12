package com.makako.makakoDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makako.entity.producto;

public interface productoDAO extends JpaRepository<producto, Integer> {

}
