package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetKittensEqualsOne() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);

        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testDoesHaveManeEqualsTrueWhenIsSamec() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeEqualsFalseWhenIsSamka() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testCreationExceptionWhenUnknownSex() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion(feline, "Оно");
    }

    @Test
    public void testGetFoodEqualsFoodForPredator() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}