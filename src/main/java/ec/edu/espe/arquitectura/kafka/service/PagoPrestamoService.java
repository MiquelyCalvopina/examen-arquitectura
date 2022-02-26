/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka.service;

import ec.edu.espe.arquitectura.kafka.model.PagoPrestamo;
import org.springframework.stereotype.Service;
import ec.edu.espe.arquitectura.kafka.dao.PagoPrestamoRepository;

@Service
public class PagoPrestamoService {

    private final PagoPrestamoRepository personaRepository;

    public PagoPrestamoService(PagoPrestamoRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public void guardarPagoPrestamo(PagoPrestamo pago) {
        this.personaRepository.save(pago);
    }
}
