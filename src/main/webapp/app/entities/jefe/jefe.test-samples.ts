import { IJefe, NewJefe } from './jefe.model';

export const sampleWithRequiredData: IJefe = {
  id: 24825,
  nombreJefe: 'abaft',
  telefonoJefe: 'facilitate till past',
};

export const sampleWithPartialData: IJefe = {
  id: 18563,
  nombreJefe: 'pneumonia',
  telefonoJefe: 'aw sunbathe cod',
};

export const sampleWithFullData: IJefe = {
  id: 25923,
  nombreJefe: 'unless',
  telefonoJefe: 'questioningly willfully',
};

export const sampleWithNewData: NewJefe = {
  nombreJefe: 'mobilize which',
  telefonoJefe: 'hunt',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
