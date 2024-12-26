package com.tarosuke777.secret;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

  @Autowired PersonRepository repository;

  @GetMapping(value = {"/"})
  public String getHello(Model model) {
    Person person = new Person();
    person.setName("John");

    repository.save(person);
    Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);

    model.addAttribute("person", saved);

    return "hello";
  }
}
