package com.example.student.Service.Impl;

import com.example.student.Repository.MatiereRepository;
import com.example.student.Service.facade.MatiereService;
import com.example.student.exception.Matiere.MatiereExistException;
import com.example.student.exception.Matiere.MatiereNotFoundException;
import com.example.student.model.Matiere;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class MatiereServiceImpl implements MatiereService {
    final MatiereRepository matiereService;
    @Override
    public Matiere create(Matiere matiere) throws Exception{
        Matiere matiereComingFromDB = matiereService.findByLabel(matiere.getLabel());
        if(matiereComingFromDB != null){
            throw new MatiereExistException(matiere.getLabel());
        }
        return matiereService.save(matiere);
    }

    @Override
    public Matiere update(Matiere matiere) throws Exception {
        // check if Matiere exists
        Matiere matiereFromDB = matiereService.findByLabel(matiere.getLabel());
        if (matiereFromDB == null) {
            try {
                throw new MatiereNotFoundException(matiere.getLabel());
            } catch (MatiereNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return matiereService.save(matiere);
    }

    @Override
    public Matiere findByName(String Name) throws Exception{

        Matiere matiereFromDB = matiereService.findByLabel(Name);
        if(matiereFromDB == null){
            try {
                throw new MatiereNotFoundException(Name);
            } catch (MatiereNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return matiereService.findByLabel(Name);
    }

    @Override
    public List<Matiere> findAll() {
        return matiereService.findAll();
    }

   // @Override
    //public Optional<Matiere> matierebyId(Long id){
     //   return matiereService.findById(id);
    //}
}
