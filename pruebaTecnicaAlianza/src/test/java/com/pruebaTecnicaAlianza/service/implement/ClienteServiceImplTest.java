package com.pruebaTecnicaAlianza.service.implement;

import com.pruebaTecnicaAlianza.model.Cliente;
import com.pruebaTecnicaAlianza.repository.ClienteRepository;
import com.pruebaTecnicaAlianza.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        cliente = new Cliente();

        java.util.Date fecha = new Date();

        cliente.setTelefonoCliente("1234567");
        cliente.setCorreoCliente("prueba@prueba.com");
        cliente.setNombreCliente("Prueba Prueba");
        cliente.setFechaInicioCliente(fecha);
        cliente.setFechaFinCliente(fecha);
    }

    @Test
    void agregarCliente() {
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        assertNotNull(clienteService.agregarCliente(new Cliente()));
    }

    @Test
    void getAll() {
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente));
        assertNotNull(clienteService.getAll());
    }

    @Test
    void modificarCliente() {
        given(clienteRepository.save(cliente)).willReturn(cliente);
        cliente.setNombreCliente("cliente prueba");

        given(clienteRepository.findById(cliente.getIdCliente())).willReturn(Optional.of(cliente));

        Cliente clienteActualizado = clienteService.modificarCliente(cliente);

        assertEquals(clienteActualizado.getNombreCliente(),"cliente prueba");

    }

    @Test
    void eliminarCliente() {
        long clienteId = 101L;
        willDoNothing().given(clienteRepository).deleteById(clienteId);

        clienteService.eliminarCliente(clienteId);

        verify(clienteRepository,times(1)).deleteById(clienteId);
    }

    @Test
    void obtenerUsuario() {

        when(clienteRepository.findByIdCliente(cliente.getIdCliente())).thenReturn(cliente);
        assertNotNull(clienteService.obtenerUsuario(cliente.getIdCliente()));

    }
}