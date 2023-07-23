package com.pruebaTecnicaAlianza.repository;

import com.pruebaTecnicaAlianza.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByIdCliente(Long idCliente);

}
