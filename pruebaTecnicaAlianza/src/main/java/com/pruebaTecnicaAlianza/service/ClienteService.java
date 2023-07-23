package com.pruebaTecnicaAlianza.service;

import com.pruebaTecnicaAlianza.model.Cliente;

public interface ClienteService {

    Cliente agregarCliente(Cliente newCliente);
    Iterable<Cliente> getAll();
    Cliente modificarCliente(Cliente cliente);
    void eliminarCliente(Long idCliente);

    Cliente obtenerUsuario(Long idCliente);


}
