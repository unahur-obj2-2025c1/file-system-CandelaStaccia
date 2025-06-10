package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarpetaTest {

    Archivo txt = new Archivo("notas", 250, "txt");
    Archivo mp3 = new Archivo("Rock", 400, "mp3");
    Archivo img = new Archivo("Foto1", 600, "jpg");
    Archivo video = new Archivo("Video1", 450, "mp4");

    Carpeta root = new Carpeta("root");
    Carpeta sub1 = new Carpeta("Sub1");
    Carpeta sub2 = new Carpeta("Sub2");


    @Test
    void dadaUnaCarpetaQueContieneSubCarpetas_ObtengoElTamanioTotal() {
        sub1.agregar(txt);
        sub2.agregar(mp3);
        sub2.agregar(img);

        root.agregar(sub1);
        root.agregar(sub2);
        root.agregar(video);

        assertEquals(1700, root.tamanio());
        assertEquals(250, sub1.tamanio());
        assertEquals(1000, sub2.tamanio());
    }


    @Test
    void dadaUnaCarpetaQueContieneSubCarpetas_ObtengoElArchivoMasPesado() {
        sub1.agregar(txt);
        sub2.agregar(mp3);
        sub2.agregar(img);

        root.agregar(sub1);
        root.agregar(sub2);
        root.agregar(video);

        
        assertEquals(img, root.archivoMasPesado());
        assertTrue(img.tamanio().equals(600));
        assertEquals("Foto1.jpg", img.nombre());
    }
}
