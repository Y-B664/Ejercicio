package co.edu.unilibre.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    private int id;
    private String nombre;
    private int edad;
    private boolean vuela;
    private String genero;
    private double peso;

    public Animal(int edad, String nombre, boolean vuela, String genero, double peso) {
        this.edad = edad;
        this.nombre = nombre;
        this.vuela = vuela;
        this.genero = genero;
        this.peso = peso;
    }
}
