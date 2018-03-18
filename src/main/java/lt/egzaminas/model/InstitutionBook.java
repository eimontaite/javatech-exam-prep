package lt.egzaminas.model;

import java.util.Objects;
//cartproduct
public class InstitutionBook {

    public Long id;
    public String title;
    public String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionBook that = (InstitutionBook) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, image);
    }
}
