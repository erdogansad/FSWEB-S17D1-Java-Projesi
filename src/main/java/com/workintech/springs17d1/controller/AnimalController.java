package com.workintech.springs17d1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.springs17d1.entity.Animal;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/")
    public Map<Integer, Animal> getAnimals() {
        return animals;
    }

    @GetMapping("/{id}")
    public Animal getAnimal(Integer id) {
        return animals.get(id);
    }

    @PostMapping("/")
    public Animal createAnimal(@RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        Animal animal = new Animal(animals.size() + 1, name);
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Map<String, Object> payload) {
        String name = (String) payload.get("name");
        Animal animal = animals.get(id);
        animal.setName(name);
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        Animal animal = animals.get(id);
        animals.remove(id);
        return animal;
    }

}
