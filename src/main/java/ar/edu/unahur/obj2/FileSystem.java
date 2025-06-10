package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private List<IElemento> elementos = new ArrayList<>();

    public void agregarElemento(IElemento elemento) {
        elementos.add(elemento);
    }

    public void listar() {
        elementos.stream().forEach(
            e -> {
                e.mostrar(0);
            }
        );
    }
}
