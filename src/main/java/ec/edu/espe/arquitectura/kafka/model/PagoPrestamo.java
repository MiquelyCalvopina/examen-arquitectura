/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PAGO_PRESTAMO")
public class PagoPrestamo implements Serializable {

    private static final long serialVersionUID = 123456L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "CODIGO_PRESTAMO", nullable = false)
    private String codigoPrestamo;

    @Column(name = "VALOR_PAGO", nullable = false, length = 50)
    private BigDecimal pago;

    @Column(name = "FECHA_PAGO", nullable = false, length = 50)
    private LocalDate fecha;

    @Column(name = "HORA_PAGO", nullable = false, length = 10)
    private LocalTime hora;

    @Column(name = "NUMERO_CUOTA", nullable = false, length = 150)
    private Integer numeroCuota;

}
