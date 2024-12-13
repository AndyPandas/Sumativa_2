package com.aiep.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;

/**
 * A Empleado.
 */
@Entity
@Table(name = "empleado")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nombre_empleado", nullable = false)
    private String nombreEmpleado;

    @NotNull
    @Column(name = "apellido_empleado", nullable = false)
    private String apellidoEmpleado;

    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;

    @Column(name = "correo_empleado")
    private String correoEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "empleados", "jefes" }, allowSetters = true)
    private Departamento idDepartamento;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Empleado id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpleado() {
        return this.nombreEmpleado;
    }

    public Empleado nombreEmpleado(String nombreEmpleado) {
        this.setNombreEmpleado(nombreEmpleado);
        return this;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return this.apellidoEmpleado;
    }

    public Empleado apellidoEmpleado(String apellidoEmpleado) {
        this.setApellidoEmpleado(apellidoEmpleado);
        return this;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getTelefonoEmpleado() {
        return this.telefonoEmpleado;
    }

    public Empleado telefonoEmpleado(String telefonoEmpleado) {
        this.setTelefonoEmpleado(telefonoEmpleado);
        return this;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getCorreoEmpleado() {
        return this.correoEmpleado;
    }

    public Empleado correoEmpleado(String correoEmpleado) {
        this.setCorreoEmpleado(correoEmpleado);
        return this;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Departamento getIdDepartamento() {
        return this.idDepartamento;
    }

    public void setIdDepartamento(Departamento departamento) {
        this.idDepartamento = departamento;
    }

    public Empleado idDepartamento(Departamento departamento) {
        this.setIdDepartamento(departamento);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Empleado)) {
            return false;
        }
        return getId() != null && getId().equals(((Empleado) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Empleado{" +
            "id=" + getId() +
            ", nombreEmpleado='" + getNombreEmpleado() + "'" +
            ", apellidoEmpleado='" + getApellidoEmpleado() + "'" +
            ", telefonoEmpleado='" + getTelefonoEmpleado() + "'" +
            ", correoEmpleado='" + getCorreoEmpleado() + "'" +
            "}";
    }
}
