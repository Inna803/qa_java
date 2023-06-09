package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {

    @Mock
    Feline feline;
    AlexLion alexLion;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testGetNameEqualsAlex() throws Exception {
        alexLion = new AlexLion(feline);

        assertEquals("Алекс", alexLion.getName());
    }
}
