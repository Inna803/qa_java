package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametersTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return List.of(new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        });
    }

    private final Feline feline;
    private final String animalKind;
    private final List<String> food;

    public FelineParametersTest(String animalKind, List<String> food) {
        this.feline = new Feline();
        this.animalKind = animalKind;
        this.food = food;
    }

    @Test
    public void testShouldReturnCorrectFood() throws Exception {
        List<String> actualFood = feline.getFood(animalKind);

        assertEquals(food, actualFood);
    }
}