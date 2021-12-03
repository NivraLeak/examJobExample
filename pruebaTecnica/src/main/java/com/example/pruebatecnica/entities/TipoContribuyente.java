package com.example.pruebatecnica.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_contribuyente", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "estado", nullable = false)
    private Boolean state;

    @OneToMany(mappedBy = "tipoContribuyente",fetch = FetchType.LAZY)
    private List<Entidad> entidads = new ArrayList<>();

}
