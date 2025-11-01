package com.example.HospitalMgmtSys.controlller;

import com.example.HospitalMgmtSys.dto.DoctorDto;
import com.example.HospitalMgmtSys.dto.DoctorResponseDto;
import com.example.HospitalMgmtSys.entity.Doctor;
import com.example.HospitalMgmtSys.service.DoctorService;
import com.example.HospitalMgmtSys.service.impl.DoctorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Slf4j
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    // ✅ CREATE Doctor
    @Operation(
            summary = "Create a new doctor profile",
            description = """
                    This API creates a new doctor record in the system.
                    It accepts a DoctorDto object in the request body and returns 
                    a DoctorResponseDto containing saved doctor details.
                    Example use case: Admin adds a new doctor to the system.
                    """
    )
    @PostMapping("/create")
    public ResponseEntity<DoctorResponseDto> createDoctor(@RequestBody DoctorDto doctorDto){

        log.info("Request to create new doctor is {}",doctorDto);

        log.info("calling service method to create doctor...");

        DoctorResponseDto doctorRes= doctorService.createDoctor(doctorDto);

        log.info("Doctor creation request: {}, Response after saving: {}", doctorDto, doctorRes);

        return  ResponseEntity.status(HttpStatus.CREATED).body(doctorRes);

    }

    // ✅ GET Doctor by ID
    @Operation(
            summary = "Fetch doctor details by ID",
            description = """
                    This API retrieves doctor information for the given ID.
                    It returns a DoctorResponseDto if the doctor is found, or throws an exception if not found.
                    Example use case: View specific doctor's profile by ID.
                    """
    )
    @GetMapping("/getDoctorInfo/{id}")
    public ResponseEntity<DoctorResponseDto> getDoctorInfoById(@PathVariable(name="id") Long id){

        log.info("Requested doctor id is {}",id);

        log.info("calling service getDoctorInfo method for this id - {}",id);
        // create service method to fetch the detials of doctor by id.
        DoctorResponseDto doctorDetails=doctorService.getDoctorInfo(id);

        log.info("Request id is {} and Response from service method is {}",id,doctorDetails.toString());


        return ResponseEntity.ok(doctorDetails);
    }

    // ✅ GET All Doctors
    @Operation(
            summary = "Retrieve all registered doctors",
            description = """
                    This API fetches a list of all doctors currently stored in the system.
                    It returns a list of DoctorResponseDto objects.
                    Example use case: Display all doctors on admin dashboard.
                    """
    )
    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctors(){

        log.info("In controller calling getAlldoctors service method");

        List<DoctorResponseDto> doctorDtoList=doctorService.getAllDoctors();

        return ResponseEntity.ok(doctorDtoList);

    }

    // used patch mapping to update the doctor profile that more feasible i have created  this for practice and future use.
    // ✅ UPDATE Doctor by ID
    @Operation(
            summary = "Update an existing doctor's profile by ID",
            description = """
                    This API updates the details of an existing doctor using the provided ID.
                    It accepts a DoctorDto containing new data and returns the updated DoctorResponseDto.
                    Example use case: Admin edits a doctor's profile information.
                    """
w    @PutMapping("/update/{id}")
    public DoctorResponseDto updateDoctorById(@PathVariable(name="id") Long id,@RequestBody DoctorDto doctorDto){

        log.info("calling service update Doctor for this id - {} and request body {}",id,doctorDto.toString());

        //call update doctor service method via id
        DoctorResponseDto updatedDoctor =doctorService.updateDoctorInfo(id,doctorDto);

        log.info("Request to update doctor is {} and response after " +
                "calling updateDoctorInfo service method is {}",
                doctorDto.toString(),updatedDoctor.toString());

        return updatedDoctor;
    }
}
