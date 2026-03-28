package com.sagnikchakraborty.sfgpetclinic.controllers;

import com.sagnikchakraborty.sfgpetclinic.fauxspring.Model;
import com.sagnikchakraborty.sfgpetclinic.fauxspring.ModelMapImpl;
import com.sagnikchakraborty.sfgpetclinic.model.Vet;
import com.sagnikchakraborty.sfgpetclinic.services.SpecialtyService;
import com.sagnikchakraborty.sfgpetclinic.services.VetService;
import com.sagnikchakraborty.sfgpetclinic.services.map.SpecialityMapService;
import com.sagnikchakraborty.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController controller;
    VetService vetService;
    SpecialtyService specialtyService;

    @BeforeEach
    void setUp() {
        specialtyService = new SpecialityMapService();
        vetService = new VetMapService(specialtyService);
        controller = new VetController(vetService);

        Vet vet1 = new Vet(1L, "Jane", "Doe", null);
        Vet vet2 = new Vet(2L, "Robert", "Smith", null);
        vetService.save(vet1);
        vetService.save(vet2);
    }

    @Test
    void listVets() {
        Model model = new ModelMapImpl();
        String view = controller.listVets(model);

        assertEquals("vets/index", view);
        assertThat(view).isEqualTo("vets/index");

        Set modelAttribute = (Set) ((ModelMapImpl) model).getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}