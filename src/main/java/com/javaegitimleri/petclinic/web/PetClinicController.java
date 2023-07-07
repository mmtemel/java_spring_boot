package com.javaegitimleri.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javaegitimleri.petclinic.service.PetClinicService;

//controller anotasyonu sayesinde spring container bu sınıftan
//bir kontrol bean'i oluşturacak ve sınıfın metodlarındaki request
//mapping anotasyonlarını tarayarak gelen web isteklerini ilgili
//ilgili metodlarla eşleştirmeye çalışcak.
@Controller
public class PetClinicController {

    //spring container bootstrap sırasında petclinic sevice
    //tipindeki bean'i controller bean'imize enjecte edecek.
    @Autowired
    private PetClinicService petClinicService;

    @RequestMapping("/owners")
    public ModelAndView getOwners(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("owners", petClinicService.findOwners());
        mav.setViewName("owners");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/pcs")
    public String welcome(){
        return "Welcome to PetClinic World!";
    }
}
