import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 8960,
  login: 'j',
};

export const sampleWithPartialData: IUser = {
  id: 23864,
  login: 'Jv@K7k\\!dZn6O\\eZXr\\hzxd6w',
};

export const sampleWithFullData: IUser = {
  id: 2793,
  login: 'NN',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
