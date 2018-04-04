package lt.egzaminas.model;

import java.util.Set;

public class Institution {

	public Long id;
    public String institutionTitle;
    public String city;
    public Set<InstitutionBook> books;
    public Set<Institution> institutions;
}
