package com.makako.makakoDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makako.entity.comprobante_de_pago;

public interface comprobanteDAO extends JpaRepository<comprobante_de_pago, Integer>{

}
