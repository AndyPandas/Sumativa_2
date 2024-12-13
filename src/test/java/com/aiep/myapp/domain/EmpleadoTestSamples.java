package com.aiep.myapp.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class EmpleadoTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Empleado getEmpleadoSample1() {
        return new Empleado()
            .id(1L)
            .nombreEmpleado("nombreEmpleado1")
            .apellidoEmpleado("apellidoEmpleado1")
            .telefonoEmpleado("telefonoEmpleado1")
            .correoEmpleado("correoEmpleado1");
    }

    public static Empleado getEmpleadoSample2() {
        return new Empleado()
            .id(2L)
            .nombreEmpleado("nombreEmpleado2")
            .apellidoEmpleado("apellidoEmpleado2")
            .telefonoEmpleado("telefonoEmpleado2")
            .correoEmpleado("correoEmpleado2");
    }

    public static Empleado getEmpleadoRandomSampleGenerator() {
        return new Empleado()
            .id(longCount.incrementAndGet())
            .nombreEmpleado(UUID.randomUUID().toString())
            .apellidoEmpleado(UUID.randomUUID().toString())
            .telefonoEmpleado(UUID.randomUUID().toString())
            .correoEmpleado(UUID.randomUUID().toString());
    }
}
