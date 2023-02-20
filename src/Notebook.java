import java.util.Objects;

/*

 */
public class Notebook {
    String model;
    String brand;
    int ram;
    int hd;
    String os;

    public Notebook(String b, String m, int r, int h, String o) {
        model = m;
        brand = b;
        ram = r;
        hd = h;
        os = o;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return ram == notebook.ram && hd == notebook.hd && Objects.equals(model, notebook.model) && Objects.equals(brand, notebook.brand) && Objects.equals(os, notebook.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, brand, ram, hd, os);
    }

    public String toString() {
        return brand + " " + model + " " + ram + "Gb/" + hd +"Gb";
    }

}
