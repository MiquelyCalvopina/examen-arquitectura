/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka.dao;

import ec.edu.espe.arquitectura.kafka.model.PagoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoPrestamoRepository extends JpaRepository<PagoPrestamo, Integer>{
    
}
