package com.fengziboboy.demo.web;

import com.fengziboboy.demo.Ingredient;
import com.fengziboboy.demo.Ingredient.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tor", Type.WRAP),
                new Ingredient("COTO", "Flour Tor", Type.WRAP),
                new Ingredient("GRBF", "Flour Tor", Type.PROTEIN),
                new Ingredient("CARN", "Flour Tor", Type.PROTEIN),
                new Ingredient("TMTO", "Flour Tor", Type.VEGGIES),
                new Ingredient("LETC", "Flour Tor", Type.VEGGIES),
                new Ingredient("CHED", "Flour Tor", Type.CHEESE),
                new Ingredient("JACK", "Flour Tor", Type.CHEESE),
                new Ingredient("SLSA", "Flour Tor", Type.SAUCE),
                new Ingredient("SRCR", "Flour Tor", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
