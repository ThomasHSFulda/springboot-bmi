package com.example.bmi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Author: Thomas Niestroj
 * Created: 07.11.2023
 * */
@Controller
public class BMIController {
	
	@Autowired // This means to get the bean called userRepository
	private BMIRepository bmiRepo;
	
	@GetMapping("/")
	public String bmiForm(Model model) {
		model.addAttribute("bmi", new BmiBean());
		System.err.println(model.getAttribute("bmi"));
		return "index";
	}
	
	@PostMapping("/")
	public String bmiForm(@ModelAttribute BmiBean bmi, Model model) {
		model.addAttribute("bmi", bmi);
		System.err.println(model.getAttribute("bmi"));
		System.err.println(bmi.getHeight());
		System.err.println(bmi.getWeight());
		try {
			bmi.setBmi(BMICalculator.calculate(bmi.getHeight(), bmi.getWeight()));
		} catch (Exception e) {
			System.err.println(e);
			bmi.setBmi(-1);
		}
		bmiRepo.save(bmi);
		return "index";
	}
	
	// Add a new endpoint to fetch data
    @GetMapping("/bmi-data")
    public @ResponseBody Iterable<BmiBean> getAllBmiData() {
    	String asdf = ";";
        return bmiRepo.findAll();
    }
}
