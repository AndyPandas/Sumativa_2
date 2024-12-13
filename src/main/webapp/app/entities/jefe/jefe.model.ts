import { IDepartamento } from 'app/entities/departamento/departamento.model';

export interface IJefe {
  id: number;
  nombreJefe?: string | null;
  telefonoJefe?: string | null;
  departamentos?: IDepartamento[] | null;
}

export type NewJefe = Omit<IJefe, 'id'> & { id: null };
