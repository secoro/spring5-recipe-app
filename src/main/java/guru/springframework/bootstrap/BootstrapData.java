package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootstrapData(RecipeRepository recipeRepository, CategoryRepository categoryRepository,
                         UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        log.debug("Bootstrapping yummy recipes!");

        List<Recipe> recipes = new ArrayList<>();

        Optional<Category> mexicanOptional = categoryRepository.findByDescription("Mexican");
        Optional<Category> fastfoodOptional = categoryRepository.findByDescription("Fast Food");

        if (!mexicanOptional.isPresent() || !fastfoodOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Category mexican = mexicanOptional.get();

        if (!fastfoodOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Category fastfood = fastfoodOptional.get();

        Optional<UnitOfMeasure> teaspoonOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        Optional<UnitOfMeasure> cloveOptional = unitOfMeasureRepository.findByDescription("Clove");
        Optional<UnitOfMeasure> tablespoonOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        Optional<UnitOfMeasure> poundOptional = unitOfMeasureRepository.findByDescription("Pound");
        Optional<UnitOfMeasure> eachOptional = unitOfMeasureRepository.findByDescription("Each");
        Optional<UnitOfMeasure> dashOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!tablespoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure tablespoon = tablespoonOptional.get();

        if (!teaspoonOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure teaspoon = teaspoonOptional.get();

        if (!cloveOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure clove = cloveOptional.get();

        if (!poundOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure pound = poundOptional.get();

        if (!eachOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure each = eachOptional.get();

        if (!dashOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        UnitOfMeasure dash = dashOptional.get();

        // *************************************************************************************************************
        // Spicy Grilled Chicken Tacos Recipe
        // *************************************************************************************************************
        Recipe spicyTacos = new Recipe();
        spicyTacos.setDescription("Spicy Grilled Chicken Tacos");
        spicyTacos.setPrepTime(9);
        spicyTacos.setCookTime(20);
        spicyTacos.setDifficulty(Difficulty.MODERATE);
        spicyTacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n");

        Notes spicyTacoNotes = new Notes();
        spicyTacos.setNotes(spicyTacoNotes);
        spicyTacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.");

        // Recipe One Categories
        spicyTacos.getCategories().add(mexican);

        // Recipe One Ingredients
        spicyTacos.getIngredients().add(new Ingredient("Ancho chili powder", BigDecimal.valueOf(2), tablespoon));
        spicyTacos.getIngredients().add(new Ingredient("Dried oregano", BigDecimal.valueOf(1), teaspoon));
        spicyTacos.getIngredients().add(new Ingredient("Dried cumin", BigDecimal.valueOf(1), teaspoon));
        spicyTacos.getIngredients().add(new Ingredient("Sugar", BigDecimal.valueOf(1), teaspoon));
        spicyTacos.getIngredients().add(new Ingredient("Salt", BigDecimal.valueOf(0.5), teaspoon));
        spicyTacos.getIngredients().add(new Ingredient("Garlic, finely chopped", BigDecimal.valueOf(1), clove));
        spicyTacos.getIngredients().add(new Ingredient("Finely grated orange zest", BigDecimal.valueOf(1), tablespoon));
        spicyTacos.getIngredients().add(new Ingredient("Fresh-squeezed orange juice", BigDecimal.valueOf(3), tablespoon));
        spicyTacos.getIngredients().add(new Ingredient("Olive oil", BigDecimal.valueOf(2), tablespoon));
        spicyTacos.getIngredients().add(new Ingredient("4 to 6 Skinless, boneless chicken", BigDecimal.valueOf(1.25), pound));

        recipes.add(spicyTacos);

        // *************************************************************************************************************
        // Perfect Guacamole Recipe
        // *************************************************************************************************************
        Recipe perfectGuacamole = new Recipe();
        perfectGuacamole.setDescription("Perfect Guacamole");
        perfectGuacamole.setPrepTime(10);
        perfectGuacamole.setCookTime(0);
        perfectGuacamole.setDifficulty(Difficulty.EASY);
        perfectGuacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n");

        Notes guacNotes = new Notes();
        perfectGuacamole.setNotes(guacNotes);
        guacNotes.setRecipeNotes("Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). You can get creative with homemade guacamole!\n" +
                "\n" +
                "Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");


        // Recipe Two Categories
        perfectGuacamole.getCategories().add(fastfood);

        // Recipe Two Ingredients
        perfectGuacamole.getIngredients().add(new Ingredient("Ripe avocados", BigDecimal.valueOf(2), each));
        perfectGuacamole.getIngredients().add(new Ingredient("Salt, more to taste", BigDecimal.valueOf(0.25), teaspoon));
        perfectGuacamole.getIngredients().add(new Ingredient("Fresh lime juice or lemon juice", BigDecimal.valueOf(1), tablespoon));
        perfectGuacamole.getIngredients().add(new Ingredient("Minced red onion or thinly sliced green onion", BigDecimal.valueOf(2), tablespoon));
        perfectGuacamole.getIngredients().add(new Ingredient("Serrano chiles, stems and seeds removed, minced", BigDecimal.valueOf(1), each));
        perfectGuacamole.getIngredients().add(new Ingredient("Cilantro (leaves and tender stems), finely chopped", BigDecimal.valueOf(2), each));
        perfectGuacamole.getIngredients().add(new Ingredient("Freshly grated black pepper", BigDecimal.valueOf(1), dash));
        perfectGuacamole.getIngredients().add(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", BigDecimal.valueOf(0.5), each));
        perfectGuacamole.getIngredients().add(new Ingredient("Red radishes or jicama, to garnish", BigDecimal.valueOf(2), each));
        perfectGuacamole.getIngredients().add(new Ingredient("Tortilla chips", BigDecimal.valueOf(50), each));

        recipes.add(perfectGuacamole);

        return recipes;
    }
}
