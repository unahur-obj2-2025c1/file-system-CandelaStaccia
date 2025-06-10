package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carpeta implements IElemento{
    private List<IElemento> elementos = new ArrayList<>();
    //IElemento elemento = new Archivo(); 
    //interfaz              concreto
    private String nombre;

    public Carpeta(String nombre){
        this.nombre = nombre;
    } //la lista empieza vacia. La carpeta se crea vacía

    public void agregar(IElemento elemento) {
        elementos.add(elemento);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Integer tamanio() {
        return elementos.stream().mapToInt(e -> e.tamanio()).sum();
        //recursividad: tamaño se llama a si mismo si es una carpeta
    }

    @Override
    public void mostrar(Integer identacion) {
        System.out.println(" ".repeat(identacion) + "└ " + nombre + " ( " + this.tamanio() + "-Bytes )");
        elementos.stream().forEach(e -> e.mostrar(identacion + 3));
    }

    @Override
    public Archivo archivoMasPesado() {
        return elementos.stream().map(e -> e.archivoMasPesado()).max(
            Comparator.comparingInt(e -> e.tamanio())
        ).orElseThrow();
        //Comparator compara los elementos por tamaño (Integer)
        //si la lista es nula, tira una excepcion
        //el q pesa mas entre los que pesan mas (??)
    }
}
