package guru.springframework.controllers;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.services.IngredientService;
import guru.springframework.services.RecipeService;
import guru.springframework.services.UnitOfMeasureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IngredientControllerTest {

    @Mock
    IngredientService ingredientService;

    @Mock
    RecipeService recipeService;

    @Mock
    UnitOfMeasureService unitOfMeasureService;

    IngredientController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new IngredientController(ingredientService, recipeService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

// TODO: FIX THIS TEST

//    @Test
//    public void testNewIngredientForm() throws Exception {
//        RecipeCommand recipeCommand = new RecipeCommand();
//        recipeCommand.setId(1L);
//
//        when(recipeService.findCommandById(anyLong())).thenReturn(recipeCommand);
//        when(unitOfMeasureService.getUomSet()).thenReturn(new HashSet<>());
//
//        mockMvc.perform(get("/recipe/1/ingredient/new"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("recipe/ingredient/ingredientform"))
//                .andExpect(model().attributeExists("ingredient"))
//                .andExpect(model().attributeExists("uomList"));
//
//        verify(recipeService, times(1)).findCommandById(anyLong());
//    }

// TODO: FIX THIS TEST

//    @Test
//    public void listIngredients() throws Exception {
//        RecipeCommand command = new RecipeCommand();
//        when(recipeService.findCommandById(anyLong())).thenReturn(command);
//
//        mockMvc.perform(get("/recipe/1/ingredients"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("recipe/ingredient/list"))
//                .andExpect(model().attributeExists("recipe"));
//
//        verify(recipeService, times(1)).findCommandById(anyLong());
//    }

// TODO: FIX THIS TEST

//    @Test
//    public void testShowIngredient() throws Exception {
//        // given
//        IngredientCommand ingredientCommand = new IngredientCommand();
//
//        // when
//        when(ingredientService.findByRecipeIdAndIngredientId(anyLong(), anyLong())).thenReturn(ingredientCommand);
//
//        // then
//        mockMvc.perform(get("/recipe/1/ingredient/2/show")).andExpect(status().isOk())
//                .andExpect(view().name("recipe/ingredient/show"))
//                .andExpect(model().attributeExists("ingredient"));
//    }

// TODO: FIX THIS TEST

//    @Test
//    public void testDeleteAction() throws Exception {
//        mockMvc.perform(get("/recipe/1/ingredient/1/delete"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/recipe/1/ingredients"));
//
//        verify(ingredientService, times(1)).deleteById(anyLong(), anyLong());
//    }
}