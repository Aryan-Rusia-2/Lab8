package com.example.lab8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        assertTrue(list.hasCity(new City("Estevan", "SK")));
        assertFalse(list.hasCity(new City("Montreal", "QC")));

    }

    @Test
    public void testDelCity() {
        list = MockCityList();
        City cityToAddAndRemove = new City("Moose Jaw", "SK");
        list.addCity(cityToAddAndRemove);
        assertTrue(list.hasCity(cityToAddAndRemove));

        list.delCity(cityToAddAndRemove);
        assertFalse(list.hasCity(cityToAddAndRemove));
    }

    @Test
    public void testCountCities() {
        list = MockCityList();

        assertEquals(0, list.countCity(), "List should be empty initially.");
        // Add a city and verify countCity reflects the correct count.
        list.addCity(new City("Estevan", "SK"));
        assertEquals(1, list.countCity(), "countCity should return 1 after adding a city.");

        // Add another city and verify countCity.
        list.addCity(new City("Regina", "SK"));
        assertEquals(2, list.countCity(), "countCity should return 2 after adding another city.");

        // Delete a city and verify countCity reflects the correct count.
        list.delCity(new City("Estevan", "SK"));
        assertEquals(1, list.countCity(), "countCity should return 1 after deleting a city.");
    }
}
