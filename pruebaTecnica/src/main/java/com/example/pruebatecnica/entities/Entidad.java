package com.example.pruebatecnica.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_entidad")
public class Entidad {
    @Id
    @Column(name = "id_entidad", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nro_documento", nullable = false, length = 11)
    private String documentNumber;

    @Column(name = "razon_social", nullable = false, length = 100)
    private String businessName;

    @Column(name = "nombre_comercial", nullable = false, length = 100)
    private String commercialName;

    @Column(name = "direccion", nullable = false, length = 250)
    private String address;

    @Column(name = "telefono", nullable = false, length = 50)
    private Integer phone;

    @Column(name = "estado", nullable = false)
    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_contribuyente", unique = true)
    private TipoContribuyente tipoContribuyente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento", unique = true)
    private TipoDocumento tipoDocumento;
}
