package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals( 0, mockCity().compareTo(cityList.getCities().get(1)));
    }

























    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city1 = new City("city1", "1");
        cityList.add(city1);
        City city2 = new City("city2", "2");
        cityList.add(city2);
        assertEquals(3, cityList.getCities().size());

        cityList.deleteCity(city1);
        assertEquals(2, cityList.getCities().size());

        assertTrue(!cityList.getCities().contains(city1));
        assertTrue(cityList.getCities().contains(city2));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        cityList.deleteCity(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }




    void testCountNumberOfCities() {
        CityList cityList = mockCityList();

        City city1 = new City("city1", "1");
        cityList.add(city1);
        City city2 = new City("city2", "2");
        cityList.add(city2);


        assertEquals(3, cityList.countNumberOfCity());
    }


}