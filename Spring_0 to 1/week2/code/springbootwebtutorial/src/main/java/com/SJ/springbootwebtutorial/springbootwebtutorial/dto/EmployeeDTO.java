package com.SJ.springbootwebtutorial.springbootwebtutorial.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "employees")
public class EmployeeDTO {       //DTO: Data Transfer Object- used when a user want to send the data from the clients to the controller and then to the service.
                                 //DTO stays between thr presentation layer and the service layer (don't go to persistence layer at all).

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private LocalDate dateofjoinig;
    
    private Boolean isActive;

//    public EmployeeDTO(String sj, String s, LocalDate of, boolean b) {             //Default Constructor
//
//   }

    //Argument Constructor
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateofjoinig, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateofjoinig = dateofjoinig;
//        this.isActive = isActive;
//    }


    //Encapsulation: Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateofjoinig() {
//        return dateofjoinig;
//    }
//
//    public void setDateofjoinig(LocalDate dateofjoinig) {
//        this.dateofjoinig = dateofjoinig;
//    }
//
//    public Boolean getActive() {
//        return isActive;
//    }
//
//    public void setActive(Boolean active) {
//        isActive = active;
//    }

}
