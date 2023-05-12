package com.makako.makakoDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makako.entity.cat_producto;

public interface catProdDAO extends JpaRepository<cat_producto, Integer> {

}
