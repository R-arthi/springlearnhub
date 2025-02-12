package com.weboinApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weboinApplication.studentEntity.studententity;
import com.weboinApplication.stuservice.stuserviceimple;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/weboin")
public class stucontroller {
@GetMapping("/home")
public String homepage() {
	return "index";
}

@Autowired
private stuserviceimple usi;
@GetMapping("/form")
public String formpage() {
	return "form";
}
@PostMapping("/save")
public String savestudetails(studententity s , @RequestParam(required = false)String Message, Model model) {
	usi.savestu(s);
	List<studententity> se = usi.viewAll();
	model.addAttribute("se",se);
	model.addAttribute("message",Message);
	return "view";
}
@GetMapping("/learn")
public String main(@RequestParam(required = false) studententity s,String status,Model model) {
	long num =usi.gettotal();
	model.addAttribute("se",num);
	long placed = usi.countbyColumn("placed");
	long unplaced = usi.countbyColumn("unplaced");
	model.addAttribute("placed",placed);
	model.addAttribute("unplaced",unplaced);
	return"learn";
}

@GetMapping("/del")
public String deletedetails(@RequestParam Integer id, RedirectAttributes attribute) {
	usi.delete(id);
	return "form";
}

}
