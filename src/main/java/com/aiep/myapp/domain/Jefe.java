package com.aiep.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Jefe.
 */
@Entity
@Table(name = "jefe")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Jefe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nombre_jefe", nullable = false)
    private String nombreJefe;

    @NotNull
    @Column(name = "telefono_jefe", nullable = false)
    private String telefonoJefe;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rel_jefe__departamentos",
        joinColumns = @JoinColumn(name = "jefe_id"),
        inverseJoinColumns = @JoinColumn(name = "departamentos_id")
    )
    @JsonIgnoreProperties(value = { "empleados", "jefes" }, allowSetters = true)
    private Set<Departamento> departamentos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Jefe id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreJefe() {
        return this.nombreJefe;
    }

    public Jefe nombreJefe(String nombreJefe) {
        this.setNombreJefe(nombreJefe);
        return this;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String getTelefonoJefe() {
        return this.telefonoJefe;
    }

    public Jefe telefonoJefe(String telefonoJefe) {
        this.setTelefonoJefe(telefonoJefe);
        return this;
    }

    public void setTelefonoJefe(String telefonoJefe) {
        this.telefonoJefe = telefonoJefe;
    }

    public Set<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    public void setDepartamentos(Set<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public Jefe departamentos(Set<Departamento> departamentos) {
        this.setDepartamentos(departamentos);
        return this;
    }

    public Jefe addDepartamentos(Departamento departamento) {
        this.departamentos.add(departamento);
        return this;
    }

    public Jefe removeDepartamentos(Departamento departamento) {
        this.departamentos.remove(departamento);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Jefe)) {
            return false;
        }
        return getId() != null && getId().equals(((Jefe) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Jefe{" +
            "id=" + getId() +
            ", nombreJefe='" + getNombreJefe() + "'" +
            ", telefonoJefe='" + getTelefonoJefe() + "'" +
            "}";
    }
}
