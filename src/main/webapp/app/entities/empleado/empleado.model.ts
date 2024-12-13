import { IDepartamento } from 'app/entities/departamento/departamento.model';

export interface IEmpleado {
  id: number;
  nombreEmpleado?: string | null;
  apellidoEmpleado?: string | null;
  telefonoEmpleado?: string | null;
  correoEmpleado?: string | null;
  idDepartamento?: IDepartamento | null;
}

export type NewEmpleado = Omit<IEmpleado, 'id'> & { id: null };
