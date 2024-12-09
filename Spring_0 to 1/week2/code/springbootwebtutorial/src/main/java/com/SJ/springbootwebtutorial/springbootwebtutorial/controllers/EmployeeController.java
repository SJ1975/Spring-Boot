package com.SJ.springbootwebtutorial.springbootwebtutorial.controllers;


import com.SJ.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.SJ.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.SJ.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.SJ.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import com.SJ.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message: In the name allah, Jai wahe Guru";
//    }


//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
//        if(employeeDTO == null) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(employeeDTO);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with id: "+id));
//                .orElse(ResponseEntity.notFound().build());
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public String handleResourceNotFound(NoSuchElementException exception){
//        return "Employee not Found";
//    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                             @RequestParam(required = false) String sortBy){
//        return employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        return employeeService.createNewEmployee(inputEmployee);
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));

    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
//        return employeeService.deleteEmployeeById(employeeId);
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                             @PathVariable Long employeeId){
//        return employeeService.updatePartialEmployeeId(employeeId, updates);
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeId(employeeId, updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

    // @PathVariable
//    @GetMapping(path = "/{employeeId}")            //GetMapping: used to get some resources from Internet
//    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long Id){
//        return new EmployeeDTO(Id, "SJ", 22, LocalDate.of(2024, 1, 2), true);
//    }
//
//
//    @GetMapping(path = "/{employeeId}")            //not a recommended practice, controller and repository should be connected with service layer
//    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){
//        return employeeRepository.findById(id).orElse(null);
//    }

    // @RequestParam
//    @GetMapping
//    public String getAllEmployees(@RequestParam(required = false) Integer age,
//                                  @RequestParam(required = false) String sortBy){
//        return "Hi, age  "+age+" "+sortBy;
//    }
//
//    @GetMapping
//    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
//                                @RequestParam(required = false) String sortBy){
//        return employeeRepository.findAll();
//    }



//    @PostMapping      //POST- Add some new Resources over the Internet
//    public String createNewEmployee(){
//        return "Hello, from POST";
//    }

//    @PostMapping
//    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        return employeeRepository.save(inputEmployee);
//    }


//    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
//        return inputEmployee;
//    }

//    @PutMapping String updateEmployeeByID(){           //PUT- updating the created resource
//        return "Hello from PUT";
//    }



}

