package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String listCar(Model model){
        model.addAttribute("cars",carRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String carForm(Model model){
        model.addAttribute("car",new Car());
        return "carform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Car car, BindingResult result){
        if(result.hasErrors()){
            return "carform";
        }
        carRepository.save(car);
        return "redirect:/";

    }
    @RequestMapping("/detail/{year}")
    public String showCar(@PathVariable("year") long year, Model model){
        model.addAttribute("car",carRepository.findById(year).get());
        return "show";
    }
    @RequestMapping("/update/{year}")
    public String updateTodo(@PathVariable("year") long year,Model model){
        model.addAttribute("year",carRepository.findById(year).get());
        return "carform";
    }
    @RequestMapping("/delete/{year}")
    public String delCourse(@PathVariable("year") long year){

        carRepository.deleteById(year);
        return "redirect:/";
    }

}
