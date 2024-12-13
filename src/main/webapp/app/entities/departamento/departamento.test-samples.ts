import { IDepartamento, NewDepartamento } from './departamento.model';

export const sampleWithRequiredData: IDepartamento = {
  id: 23778,
  nombreDepartamento: 'meanwhile failing',
};

export const sampleWithPartialData: IDepartamento = {
  id: 27854,
  nombreDepartamento: 'towards forage',
  ubicacionDepartamento: 'statement provided',
};

export const sampleWithFullData: IDepartamento = {
  id: 17549,
  nombreDepartamento: 'leap come out',
  ubicacionDepartamento: 'deeply abaft barring',
  presupuestoDepartamento: 28162,
};

export const sampleWithNewData: NewDepartamento = {
  nombreDepartamento: 'duh',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
