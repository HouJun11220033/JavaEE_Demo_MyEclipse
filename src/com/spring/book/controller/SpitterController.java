package com.spring.book.controller;

//package com.spring.controller;
//
//import com.interfaces.SpitterRepository;
//import com.model.Spitter;
//import javax.ws.rs.GET;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.springframework.web.bind.annotation.RequestMethod.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/spitter")
//public class SpitterController {
//
//    private SpitterRepository spitterRepository;
//
//    @Autowired
//    public SpitterController(SpitterRepository spitterRepository) {
//        this.spitterRepository = spitterRepository;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String showRegistrationForm() {
//        return "registerForm";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String processRegistration(Spitter spitter) {
//        spitterRepository.save(spitter);
//        return "redirect:/spitter/" + spitter.getUsername();
//
//    }
//
//    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
//    public String showSpitterProfile(@PathVariable String username, Model model) {
//        Spitter spitter = spitterRepository.findByUsername(username);
//        model.addAttribute(spitter);
//        return "profile";
//
//    }
//
// }
