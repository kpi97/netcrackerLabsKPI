package ru.vsu.netcracker.repositories.repoImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.vsu.netcracker.models.Car;
import ru.vsu.netcracker.sorts.sortsImpl.BubbleSort;
import ru.vsu.netcracker.sorts.sortsImpl.QuickSort;

import static org.junit.Assert.*;

public class CarRepositoryTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Car car4;


    @Before
    public void init() throws Exception {
        car1 = new Car("Fiat", "white", 100);           //model - 4  engine - 3
        car2 = new Car("Alfa Romeo", "black", 120);     //model - 1  engine - 4
        car3 = new Car("Doodge", "white", 95);          //model - 3  engine - 1
        car4 = new Car("BMW", "red", 98);               //model - 2  engine - 2
    }

    @After
    public void destroy() throws Exception {
        car1 = null;
        car2 = null;
        car3 = null;
        car4 = null;
    }

    @Test
    public void add(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);

        Car[] expected = new Car[4];
        expected[0] = car1;
        expected[1] = car2;
        expected[2] = car3;
        expected[3] = car4;

        assertArrayEquals(expected, carRepository.getRepository());
    }

    @Test
    public void delete(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);

        carRepository.delete(car2);

        Car[] expected = new Car[4];
        expected[0] = car1;
        expected[1] = car3;
        expected[2] = car4;

        assertArrayEquals(expected, carRepository.getRepository());
    }

    @Test
    public void deleteFalse(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);


        boolean bl = carRepository.delete(new Car());

        assertEquals(false, bl);
    }

    @Test
    public void sortById(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car4);
        carRepository.add(car3);
        carRepository.add(car2);
        carRepository.add(car1);
        carRepository.sortById();

        Car[] expected = new Car[4];
        expected[0] = car1;
        expected[1] = car2;
        expected[2] = car3;
        expected[3] = car4;


        assertArrayEquals(expected, carRepository.getRepository());
    }

    @Test
    public void sortByModel(){
        CarRepository carRepository = new CarRepository(4);

        carRepository.add(car4);
        carRepository.add(car3);
        carRepository.add(car2);
        carRepository.add(car1);
        carRepository.sortByModel();

        Car[] expected = new Car[4];
        expected[0] = car2;
        expected[1] = car4;
        expected[2] = car3;
        expected[3] = car1;

        assertArrayEquals(expected, carRepository.getRepository());
    }

    @Test
    public void sortByEnginePower(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);
        carRepository.sortByEnginePower();

        Car[] expected = new Car[4];
        expected[0] = car3;
        expected[1] = car4;
        expected[2] = car1;
        expected[3] = car2;

        assertArrayEquals(expected, carRepository.getRepository());
    }

    @Test
    public void getCarById(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);
        int index = car2.getId();

        Car actualCar = carRepository.getCarById(index);

        assertEquals(car2, actualCar);
    }

    @Test
    public void getCarByIdNull(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);

        Car actualCar = carRepository.getCarById(1000);

        assertEquals(null, actualCar);
    }

    @Test
    public void searchByModel(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);

        String model = "BMW";
        CarRepository actual = carRepository.searchByModel(model);

        Car[] expected = new Car[1];
        expected[0] = car4;


        assertArrayEquals(expected, actual.getRepository());
    }

    @Test
    public void searchByColor(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);

        String color = "white";
        CarRepository actual = carRepository.searchByColor(color);

        Car[] expected = new Car[2];
        expected[0] = car1;
        expected[1] = car3;

        assertArrayEquals(expected, actual.getRepository());
    }

    @Test
    public void searchByEnginePower(){
        CarRepository carRepository = new CarRepository(4);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);


        double enginePower = 100;
        CarRepository actual = carRepository.searchByEnginePower(enginePower);

        Car[] expected = new Car[1];
        expected[0] = car1;

        assertArrayEquals(expected, actual.getRepository());
    }

}