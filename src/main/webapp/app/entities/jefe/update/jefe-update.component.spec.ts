import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpResponse, provideHttpClient } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Subject, from, of } from 'rxjs';

import { IDepartamento } from 'app/entities/departamento/departamento.model';
import { DepartamentoService } from 'app/entities/departamento/service/departamento.service';
import { JefeService } from '../service/jefe.service';
import { IJefe } from '../jefe.model';
import { JefeFormService } from './jefe-form.service';

import { JefeUpdateComponent } from './jefe-update.component';

describe('Jefe Management Update Component', () => {
  let comp: JefeUpdateComponent;
  let fixture: ComponentFixture<JefeUpdateComponent>;
  let activatedRoute: ActivatedRoute;
  let jefeFormService: JefeFormService;
  let jefeService: JefeService;
  let departamentoService: DepartamentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [JefeUpdateComponent],
      providers: [
        provideHttpClient(),
        FormBuilder,
        {
          provide: ActivatedRoute,
          useValue: {
            params: from([{}]),
          },
        },
      ],
    })
      .overrideTemplate(JefeUpdateComponent, '')
      .compileComponents();

    fixture = TestBed.createComponent(JefeUpdateComponent);
    activatedRoute = TestBed.inject(ActivatedRoute);
    jefeFormService = TestBed.inject(JefeFormService);
    jefeService = TestBed.inject(JefeService);
    departamentoService = TestBed.inject(DepartamentoService);

    comp = fixture.componentInstance;
  });

  describe('ngOnInit', () => {
    it('Should call Departamento query and add missing value', () => {
      const jefe: IJefe = { id: 456 };
      const departamentos: IDepartamento[] = [{ id: 14121 }];
      jefe.departamentos = departamentos;

      const departamentoCollection: IDepartamento[] = [{ id: 5709 }];
      jest.spyOn(departamentoService, 'query').mockReturnValue(of(new HttpResponse({ body: departamentoCollection })));
      const additionalDepartamentos = [...departamentos];
      const expectedCollection: IDepartamento[] = [...additionalDepartamentos, ...departamentoCollection];
      jest.spyOn(departamentoService, 'addDepartamentoToCollectionIfMissing').mockReturnValue(expectedCollection);

      activatedRoute.data = of({ jefe });
      comp.ngOnInit();

      expect(departamentoService.query).toHaveBeenCalled();
      expect(departamentoService.addDepartamentoToCollectionIfMissing).toHaveBeenCalledWith(
        departamentoCollection,
        ...additionalDepartamentos.map(expect.objectContaining),
      );
      expect(comp.departamentosSharedCollection).toEqual(expectedCollection);
    });

    it('Should update editForm', () => {
      const jefe: IJefe = { id: 456 };
      const departamentos: IDepartamento = { id: 31686 };
      jefe.departamentos = [departamentos];

      activatedRoute.data = of({ jefe });
      comp.ngOnInit();

      expect(comp.departamentosSharedCollection).toContain(departamentos);
      expect(comp.jefe).toEqual(jefe);
    });
  });

  describe('save', () => {
    it('Should call update service on save for existing entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IJefe>>();
      const jefe = { id: 123 };
      jest.spyOn(jefeFormService, 'getJefe').mockReturnValue(jefe);
      jest.spyOn(jefeService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ jefe });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: jefe }));
      saveSubject.complete();

      // THEN
      expect(jefeFormService.getJefe).toHaveBeenCalled();
      expect(comp.previousState).toHaveBeenCalled();
      expect(jefeService.update).toHaveBeenCalledWith(expect.objectContaining(jefe));
      expect(comp.isSaving).toEqual(false);
    });

    it('Should call create service on save for new entity', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IJefe>>();
      const jefe = { id: 123 };
      jest.spyOn(jefeFormService, 'getJefe').mockReturnValue({ id: null });
      jest.spyOn(jefeService, 'create').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ jefe: null });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.next(new HttpResponse({ body: jefe }));
      saveSubject.complete();

      // THEN
      expect(jefeFormService.getJefe).toHaveBeenCalled();
      expect(jefeService.create).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).toHaveBeenCalled();
    });

    it('Should set isSaving to false on error', () => {
      // GIVEN
      const saveSubject = new Subject<HttpResponse<IJefe>>();
      const jefe = { id: 123 };
      jest.spyOn(jefeService, 'update').mockReturnValue(saveSubject);
      jest.spyOn(comp, 'previousState');
      activatedRoute.data = of({ jefe });
      comp.ngOnInit();

      // WHEN
      comp.save();
      expect(comp.isSaving).toEqual(true);
      saveSubject.error('This is an error!');

      // THEN
      expect(jefeService.update).toHaveBeenCalled();
      expect(comp.isSaving).toEqual(false);
      expect(comp.previousState).not.toHaveBeenCalled();
    });
  });

  describe('Compare relationships', () => {
    describe('compareDepartamento', () => {
      it('Should forward to departamentoService', () => {
        const entity = { id: 123 };
        const entity2 = { id: 456 };
        jest.spyOn(departamentoService, 'compareDepartamento');
        comp.compareDepartamento(entity, entity2);
        expect(departamentoService.compareDepartamento).toHaveBeenCalledWith(entity, entity2);
      });
    });
  });
});
