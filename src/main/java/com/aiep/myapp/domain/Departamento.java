package com.aiep.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Departamento.
 */
@Entity
@Table(name = "departamento")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nombre_departamento", nullable = false, unique = true)
    private String nombreDepartamento;

    @Column(name = "ubicacion_departamento")
    private String ubicacionDepartamento;

    @Column(name = "presupuesto_departamento")
    private Integer presupuestoDepartamento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idDepartamento")
    @JsonIgnoreProperties(value = { "idDepartamento" }, allowSetters = true)
    private Set<Empleado> empleados = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "departamentos")
    @JsonIgnoreProperties(value = { "departamentos" }, allowSetters = true)
    private Set<Jefe> jefes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Departamento id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return this.nombreDepartamento;
    }

    public Departamento nombreDepartamento(String nombreDepartamento) {
        this.setNombreDepartamento(nombreDepartamento);
        return this;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getUbicacionDepartamento() {
        return this.ubicacionDepartamento;
    }

    public Departamento ubicacionDepartamento(String ubicacionDepartamento) {
        this.setUbicacionDepartamento(ubicacionDepartamento);
        return this;
    }

    public void setUbicacionDepartamento(String ubicacionDepartamento) {
        this.ubicacionDepartamento = ubicacionDepartamento;
    }

    public Integer getPresupuestoDepartamento() {
        return this.presupuestoDepartamento;
    }

    public Departamento presupuestoDepartamento(Integer presupuestoDepartamento) {
        this.setPresupuestoDepartamento(presupuestoDepartamento);
        return this;
    }

    public void setPresupuestoDepartamento(Integer presupuestoDepartamento) {
        this.presupuestoDepartamento = presupuestoDepartamento;
    }

    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        if (this.empleados != null) {
            this.empleados.forEach(i -> i.setIdDepartamento(null));
        }
        if (empleados != null) {
            empleados.forEach(i -> i.setIdDepartamento(this));
        }
        this.empleados = empleados;
    }

    public Departamento empleados(Set<Empleado> empleados) {
        this.setEmpleados(empleados);
        return this;
    }

    public Departamento addEmpleados(Empleado empleado) {
        this.empleados.add(empleado);
        empleado.setIdDepartamento(this);
        return this;
    }

    public Departamento removeEmpleados(Empleado empleado) {
        this.empleados.remove(empleado);
        empleado.setIdDepartamento(null);
        return this;
    }

    public Set<Jefe> getJefes() {
        return this.jefes;
    }

    public void setJefes(Set<Jefe> jefes) {
        if (this.jefes != null) {
            this.jefes.forEach(i -> i.removeDepartamentos(this));
        }
        if (jefes != null) {
            jefes.forEach(i -> i.addDepartamentos(this));
        }
        this.jefes = jefes;
    }

    public Departamento jefes(Set<Jefe> jefes) {
        this.setJefes(jefes);
        return this;
    }

    public Departamento addJefes(Jefe jefe) {
        this.jefes.add(jefe);
        jefe.getDepartamentos().add(this);
        return this;
    }

    public Departamento removeJefes(Jefe jefe) {
        this.jefes.remove(jefe);
        jefe.getDepartamentos().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Departamento)) {
            return false;
        }
        return getId() != null && getId().equals(((Departamento) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Departamento{" +
            "id=" + getId() +
            ", nombreDepartamento='" + getNombreDepartamento() + "'" +
            ", ubicacionDepartamento='" + getUbicacionDepartamento() + "'" +
            ", presupuestoDepartamento=" + getPresupuestoDepartamento() +
            "}";
    }
}
