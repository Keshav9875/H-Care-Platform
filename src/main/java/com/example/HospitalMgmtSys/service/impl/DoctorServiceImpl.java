package com.example.HospitalMgmtSys.service.impl;

import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.DoctorResponseDto;
import com.example.HospitalMgmtSys.entity.Doctor;
import com.example.HospitalMgmtSys.mapper.DoctorMapper;
import com.example.HospitalMgmtSys.repository.DoctorRepository;
import com.example.HospitalMgmtSys.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DoctorServiceImpl  implements DoctorService {


    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public DoctorResponseDto createDoctor(DoctorDto doctorDto) {
          log.info("inside service create doctor method...");

          log.info("convert from Dto to Entity using MapStruct...");

         Doctor doctormapper = doctorMapper.toEntity(doctorDto);

         log.info(doctormapper.toString()+" converted to entity using mapstruct doctormapper.toEntity()");


         Doctor doctor = doctorRepository.save(doctormapper);
        System.out.println("after saving doctor is"+doctor.toString());

         DoctorResponseDto doctorDtoRes= doctorMapper.toDto(doctor);
         log.info(doctorDtoRes.toString()+" service final response.");
          return doctorDtoRes;
    }

    @Override
    public DoctorResponseDto getDoctorInfo(Long id) {

        //calling repo method to find doctor.
        log.info("calling repo method for this id - {}",id);
        Optional<Doctor>  doctorInfo = doctorRepository.findById(id);

        log.info("After calling repo method returns the optional - {}",doctorInfo.toString());

        if(doctorInfo.isPresent()){
            log.info("value present inside optional is {}",doctorInfo.get().toString());
            return doctorMapper.toDto(doctorInfo.get());
        }
        else{
            log.info("optional doesn't contain value throwing Runtime exception for that.");
            throw new RuntimeException("Doctor doesn't exist for that particular id.");
        }

    }


    @Override
    public List<DoctorResponseDto> getAllDoctors() {

        log.info("calling repository method to fetch all the doctors.");

        List<Doctor> doctorList = doctorRepository.findAll();

        List<DoctorResponseDto> doctorDtoList=doctorMapper.toDoctorDtoList(doctorList);

        return doctorDtoList;

    }

    @Override
    public DoctorResponseDto updateDoctorInfo(Long id, DoctorDto doctorDto) {

        log.info("Inside service method to update the doctor info for this id: {} and request dto is {}",id,doctorDto.toString());

        log.info("Fetch doctor for this  id : {} from db",id);

        Optional<Doctor>  fetchedDoctor= doctorRepository.findById(id);

        log.info("fetched doctor from db is {}",fetchedDoctor.isPresent()?fetchedDoctor.get():"Nothing found in db.");

        Doctor existingDoctor = fetchedDoctor
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

         log.info("call updateDoctorFromDto mapper func to change existing entity from doctordto");
         doctorMapper.updateDoctorFromDto(doctorDto,existingDoctor);

         log.info("After changing now going to save that one {}",existingDoctor.toString());

         Doctor updatedDoctor= doctorRepository.save(existingDoctor);


         log.info("After saving in db convert it into DoctorResponse dto through mapper");

         DoctorResponseDto updatedDoctorRes= doctorMapper.toDto(updatedDoctor);

         return updatedDoctorRes;

    }
}
