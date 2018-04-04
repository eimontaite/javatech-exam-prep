package lt.egzaminas.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import lt.egzaminas.model.Book;
import lt.egzaminas.model.Institution;
import lt.egzaminas.model.NewBook;
import lt.egzaminas.model.NewInstitution;

@Repository
public class InstitutionRepository {

	private final List<Institution> institutions;
	private final AtomicLong idGenerator = new AtomicLong(0);

	public InstitutionRepository() {
		institutions = Collections.synchronizedList(new ArrayList<>());

		Institution i1 = new Institution();
		i1.id = idGenerator.incrementAndGet();
		i1.institutionTitle = "Palangos knygynas";
		i1.city = "Palanga";
		institutions.add(i1);

		Institution i2 = new Institution();
		i2.id = idGenerator.incrementAndGet();
		i2.institutionTitle = "Kauno knygu nuoma";
		i2.city = "Kaunas";
		institutions.add(i2);

		Institution i3 = new Institution();
		i3.id = idGenerator.incrementAndGet();
		i3.institutionTitle = "Jonavos miesto biblioteka";
		i3.city = "Jonava";
		institutions.add(i3);
	}

	public Institution addInstitution(NewInstitution i) {
		Institution institution = new Institution();
		institution.id = idGenerator.incrementAndGet();
		institution.institutionTitle = i.institutionTitle;
		institution.city = i.city;
		institutions.add(institution);
		return institution;
	}

	public List<Institution> getInstitutions() {
		return institutions;
	}
}
