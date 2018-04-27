package kz.kaznitu.lessons.controllers;

import kz.kaznitu.lessons.models.Student;
import kz.kaznitu.lessons.models.Location;
import kz.kaznitu.lessons.repositories.LocationRepository;
import kz.kaznitu.lessons.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class StudentsController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LocationRepository locationRepository;

    @RequestMapping("/admin/student/{id}")
    public String student(@PathVariable("id")int id, Model model){
        model.addAttribute("student", studentRepository.findById(id).get());
        model.addAttribute("locations",locationRepository.findAll());
        return "student";
    }

    @RequestMapping(value = "/admin/students",method = RequestMethod.GET)
    public String studentsList(Model model){
        model.addAttribute("students",studentRepository.findAll());
        return "students";
    }
    @RequestMapping(value = "/admin/students",method = RequestMethod.POST)
    public String studentsAdd(@RequestParam String email,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam String items,
                                @RequestParam String receipt,
                                @RequestParam int phoneNumber,
                                @RequestParam String address,
                                Model model){
            Student newStudent = new Student();
            newStudent.setEmail(email);
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setItems(items);
            newStudent.setReceipt(receipt);
            newStudent.setPhoneNumber(phoneNumber);
            newStudent.setAddress(address);
            studentRepository.save(newStudent);

            model.addAttribute("student",newStudent);
            model.addAttribute("locations",locationRepository.findAll());
            return "redirect:/admin/student/" + newStudent.getId();
        }
        @RequestMapping(value = "/admin/student/{id}/locations", method = RequestMethod.POST)
        public String studentsAddLocation(@PathVariable Integer id,
                                         @RequestParam Integer locationId,
                                         Model model){
            Location location = locationRepository.findById(locationId).get();
            Student  student = studentRepository.findById(id).get();

            if(student != null){
                if(!student.hasLocation(location)){
                    student.getLocations().add(location);
                }
                studentRepository.save(student);
                model.addAttribute("student",studentRepository.findById(id).get());
                model.addAttribute("locations",locationRepository.findAll());
                return "redirect:/admin/student/" + student.getId();
            }
            model.addAttribute("students",studentRepository.findAll());
            return "redirect:/admin/students";
        }
        @RequestMapping(value = "/admin/locations",method = RequestMethod.GET)
        public String locationsAdd(Model model){
            model.addAttribute("location",new Location());
            return "locations";
        }
        @RequestMapping(value = "/admin/locations", method = RequestMethod.POST)
        public String locationsAdd(@ModelAttribute("location") @Valid Location location, Errors errors, Model model){
            if(errors.hasErrors()){
                return "locations";
            }
            locationRepository.save(location);
            return "redirect:/admin/students";
        }
    }
