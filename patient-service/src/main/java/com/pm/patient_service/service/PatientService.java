package com.pm.patient_service.service;


import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients=patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOs=patients.stream().map(patient-> PatientMapper.toDTO(patient)).toList();
        return patientResponseDTOs;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patient){
            if(patientRepository.existsByEmail(patient.getEmail())){
                throw new EmailAlreadyExistsException("A Patient with This Email already Exists"+patient.getEmail());
            }
               Patient newPatient=patientRepository.save(PatientMapper.toModel(patient));

               return PatientMapper.toDTO(newPatient);
    }
}
