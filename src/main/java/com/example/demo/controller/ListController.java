package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;	
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.ToDoList;
import com.example.demo.service.ListService;

@Controller
public class ListController {

	private ListService service;

    @Autowired
    public ListController(ListService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String showAllLists(Model model) {
        model.addAttribute("toDoList", service.findAll());
        return "toDoList";
    }
    
    @GetMapping("/markdone")
    public String markdone(@PathVariable Boolean isDeleted, Model model) {
    	ToDoList list = service.getByisDeleted(true);
             
        model.addAttribute("list", list);
        System.out.println(service.getByisDeleted(true));
        return "markdone";
    }
    //@RequestMapping("/markdone")
    //public String mark(Model model) {
     //   model.addAttribute("toDoList", service.getByisDeleted(true));
    //    return "markdone";
  //  }


    @GetMapping("/new-list")
    public String showListCreationForm(Model model) {
        model.addAttribute("list", new ToDoList());
        return "new-list";
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addNewList(@Valid @ModelAttribute ToDoList list, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "new-list";
        }
        list.setDeleted(false);       
        service.save(list);
        model.addAttribute("toDoList", service.findAll());
        return "toDoList";
    }

    @GetMapping("/{id}")
    public String showListdById(@PathVariable int id, Model model) {
    	ToDoList list = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid list Id:" + id));
        model.addAttribute("list", list);
        return "edit-list";
    }
    
    @GetMapping("/{id}/status")
    public String statusById(@PathVariable int id, Model model) {
    	ToDoList list = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid list Id:" + id));
    	list = service.getById(id);
        list.setDeleted(true);
        service.save(list);
        
        model.addAttribute("list", list);
        return "status";
    }


    @PostMapping("/{id}/update")
    public String updateList(@PathVariable int id, @Valid @ModelAttribute ToDoList list, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-list";
        }
        service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid list Id:" + id));
        service.save(list);
        model.addAttribute("toDoList", service.findAll());
        return "toDoList";
    }

    @PostMapping("/{id}/delete")
    public String deleteList(@PathVariable int id, Model model) {
        service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid list Id:" + id));
       // ToDoList list = service.getById(id);
        //list.setDeleted(true);
        //service.save(list);
        
        service.deleteById(id);
        model.addAttribute("toDoList", service.findAll());
        return "toDoList";
    }

}
