import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '3713a1ca-edc9-477c-a981-9e96965b19f6',
};

export const sampleWithPartialData: IAuthority = {
  name: 'efb2eafe-8dc6-40a7-bc27-a6fb38f23e3b',
};

export const sampleWithFullData: IAuthority = {
  name: '039ea084-89fe-4fec-931d-81d497d89690',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
