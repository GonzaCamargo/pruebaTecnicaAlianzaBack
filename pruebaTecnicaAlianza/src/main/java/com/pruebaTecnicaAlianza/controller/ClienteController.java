package com.pruebaTecnicaAlianza.controller;

import com.pruebaTecnicaAlianza.model.Cliente;
import com.pruebaTecnicaAlianza.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080"})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);


    @PostMapping("/agregar")
    public Cliente agregarCliente(@RequestBody Cliente cliente){

        logger.info("Recivet POST request with body "+cliente);
        java.util.Date fecha = new Date();
        Cliente res = this.clienteService.agregarCliente(cliente);
        return res;
    }

    @GetMapping("/mostrar")
    public Iterable<Cliente> getAll(){
        logger.info("Recibir información de clientes ");
        return this.clienteService.getAll();
    }

    @PostMapping("/modificar")
    public Cliente modificarCliente(@RequestBody Cliente cliente){
        return this.clienteService.modificarCliente(cliente);
    }

    @DeleteMapping("/{idCliente}")
    public void eliminarCliente(@PathVariable("idCliente") Long idCliente){
        this.clienteService.eliminarCliente(idCliente);
    }

    @GetMapping("/{idCliente}")
    public Cliente obtenerCliente(@PathVariable("idCliente") Long idCliente){
        return clienteService.obtenerUsuario(idCliente);
    }

}
