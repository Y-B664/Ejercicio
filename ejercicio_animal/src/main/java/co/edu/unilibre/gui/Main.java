package co.edu.unilibre.gui;

import co.edu.unilibre.dto.Animal;
import co.edu.unilibre.implOperaciones.GestorConexion;
import co.edu.unilibre.implOperaciones.ImplOperacionesBD;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ImplOperacionesBD impOperacionesBD = new ImplOperacionesBD();

    int opcion = -1;
        Scanner sc = new Scanner(System.in);
        while (opcion != 0){
            System.out.println("Que opcion necesitas?");
            System.out.println("Crear animal -> 1");
            System.out.println("Ver listado -> 2");
            System.out.println("Salir -> 0");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("¿El animal vuela? (true/false): ");
                    boolean vuela = sc.nextBoolean();
                    sc.nextLine();
                    System.out.print("Ingrese el género: ");
                    String genero = sc.nextLine();
                    System.out.print("Ingrese el peso: ");
                    double peso = sc.nextDouble();
                    sc.next();
                    Animal miAnimal = new Animal(edad, nombre, vuela, genero, peso);
                    if(impOperacionesBD.create(miAnimal)){
                        System.out.println("animal creado exitosamente");
                    }
                    break;
                case 2:
                    List<Animal> animales = impOperacionesBD.getTodos();
                    for(Animal animal :animales){
                        System.out.println("-----");
                        System.out.println("Animal " + animal.getId());
                        System.out.println("edad " + animal.getEdad());
                        System.out.println("nombre " + animal.getNombre());
                        System.out.println("genero " + animal.getGenero());
                        System.out.println("peso " + animal.getPeso());
                    }
                    break;
                default:
                    System.out.println("Esa opcion no existe");
            }
        }


    }
}