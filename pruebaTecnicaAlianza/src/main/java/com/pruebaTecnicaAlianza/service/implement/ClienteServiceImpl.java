package com.pruebaTecnicaAlianza.service.implement;

import com.pruebaTecnicaAlianza.exception.StatusException;
import com.pruebaTecnicaAlianza.model.Cliente;
import com.pruebaTecnicaAlianza.repository.ClienteRepository;
import com.pruebaTecnicaAlianza.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente agregarCliente(Cliente newCliente) {
        try {
            return clienteRepository.save(newCliente);
        }catch (Exception e){
            throw new StatusException("Error al agregar",e);
        }

    }

    @Override
    public Iterable<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        try{
            Optional<Cliente> encuentroCliente = this.clienteRepository.findById(cliente.getIdCliente());
            if (encuentroCliente.get() != null){
                encuentroCliente.get().setNombreCliente(cliente.getNombreCliente());
                encuentroCliente.get().setTelefonoCliente(cliente.getTelefonoCliente());
                encuentroCliente.get().setCorreoCliente(cliente.getCorreoCliente());
                encuentroCliente.get().setFechaInicioCliente(cliente.getFechaInicioCliente());
                encuentroCliente.get().setFechaFinCliente(cliente.getFechaFinCliente());
                return this.agregarCliente(encuentroCliente.get());
            }
            return null;
        }catch (Exception e){
            throw new StatusException("Error al modificar",e);
        }

    }

    @Override
    public void eliminarCliente(Long idCliente) {
        try {
            this.clienteRepository.deleteById(idCliente);
        }catch (Exception e){
            throw new StatusException("Error al eliminar ",e);
        }

    }

    @Override
    public Cliente obtenerUsuario(Long idCliente) {
        try {
            return this.clienteRepository.findByIdCliente(idCliente);
        }catch (Exception e){
            throw new StatusException("Error al obtener por ID ",e);
        }
    }
}
