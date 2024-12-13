package com.aiep.myapp.domain;

import static com.aiep.myapp.domain.DepartamentoTestSamples.*;
import static com.aiep.myapp.domain.EmpleadoTestSamples.*;
import static com.aiep.myapp.domain.JefeTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.aiep.myapp.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DepartamentoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Departamento.class);
        Departamento departamento1 = getDepartamentoSample1();
        Departamento departamento2 = new Departamento();
        assertThat(departamento1).isNotEqualTo(departamento2);

        departamento2.setId(departamento1.getId());
        assertThat(departamento1).isEqualTo(departamento2);

        departamento2 = getDepartamentoSample2();
        assertThat(departamento1).isNotEqualTo(departamento2);
    }

    @Test
    void empleadosTest() {
        Departamento departamento = getDepartamentoRandomSampleGenerator();
        Empleado empleadoBack = getEmpleadoRandomSampleGenerator();

        departamento.addEmpleados(empleadoBack);
        assertThat(departamento.getEmpleados()).containsOnly(empleadoBack);
        assertThat(empleadoBack.getIdDepartamento()).isEqualTo(departamento);

        departamento.removeEmpleados(empleadoBack);
        assertThat(departamento.getEmpleados()).doesNotContain(empleadoBack);
        assertThat(empleadoBack.getIdDepartamento()).isNull();

        departamento.empleados(new HashSet<>(Set.of(empleadoBack)));
        assertThat(departamento.getEmpleados()).containsOnly(empleadoBack);
        assertThat(empleadoBack.getIdDepartamento()).isEqualTo(departamento);

        departamento.setEmpleados(new HashSet<>());
        assertThat(departamento.getEmpleados()).doesNotContain(empleadoBack);
        assertThat(empleadoBack.getIdDepartamento()).isNull();
    }

    @Test
    void jefesTest() {
        Departamento departamento = getDepartamentoRandomSampleGenerator();
        Jefe jefeBack = getJefeRandomSampleGenerator();

        departamento.addJefes(jefeBack);
        assertThat(departamento.getJefes()).containsOnly(jefeBack);
        assertThat(jefeBack.getDepartamentos()).containsOnly(departamento);

        departamento.removeJefes(jefeBack);
        assertThat(departamento.getJefes()).doesNotContain(jefeBack);
        assertThat(jefeBack.getDepartamentos()).doesNotContain(departamento);

        departamento.jefes(new HashSet<>(Set.of(jefeBack)));
        assertThat(departamento.getJefes()).containsOnly(jefeBack);
        assertThat(jefeBack.getDepartamentos()).containsOnly(departamento);

        departamento.setJefes(new HashSet<>());
        assertThat(departamento.getJefes()).doesNotContain(jefeBack);
        assertThat(jefeBack.getDepartamentos()).doesNotContain(departamento);
    }
}
