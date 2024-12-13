import { IEmpleado, NewEmpleado } from './empleado.model';

export const sampleWithRequiredData: IEmpleado = {
  id: 7625,
  nombreEmpleado: 'follower mid arrogantly',
  apellidoEmpleado: 'edible lawful',
};

export const sampleWithPartialData: IEmpleado = {
  id: 9355,
  nombreEmpleado: 'jogging selfish',
  apellidoEmpleado: 'chromakey respray very',
  correoEmpleado: 'ouch',
};

export const sampleWithFullData: IEmpleado = {
  id: 7706,
  nombreEmpleado: 'meanwhile worth oxidise',
  apellidoEmpleado: 'humiliating glossy challenge',
  telefonoEmpleado: 'forswear',
  correoEmpleado: 'blink precious appropriate',
};

export const sampleWithNewData: NewEmpleado = {
  nombreEmpleado: 'swerve supposing',
  apellidoEmpleado: 'once bind as',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
