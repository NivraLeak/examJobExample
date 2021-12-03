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
@Table(name = "tb_tipo_documento")
public class TipoDocumento {
    @Id
    @Column(name = "id_tipo_documento", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo", nullable = false, length = 20)
    private String code;

    @Column(name = "nombre", nullable = false, length = 100)
    private String name;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String description;

    @Column(name = "estado", nullable = false)
    private Boolean state;

    @OneToMany(mappedBy = "tipoDocumento",fetch = FetchType.LAZY)
    private List<Entidad> entidads = new ArrayList<>();

}
