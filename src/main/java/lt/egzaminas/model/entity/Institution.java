package lt.egzaminas.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.PersistenceConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;


//@Getter
//@Setter
//@EqualsAndHashCode
@Entity
@Table(name = "Institutions")
/**
 * Entity representing institutions
 *
 */
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinColumn(name = "BOOK_ID", nullable = false)
	private Long id;

	@Column(name = "INSTITUTION_TITLE", length = 8000)
	private String institutionTitle;
	
	@Column(name = "CITY", length = 8000)
	private String city;

}
//	public Institution() {
//	}

//	@PersistenceConstructor
//	public Prescription(PrescriptionDTO prescriptionDTO, Ingredient activeIngredient, Doctor doctor, Patient patient) {
//		this.prescriptionDate = prescriptionDTO.getPrescriptionDate();
//		this.validUntil = prescriptionDTO.getValidUntil();
//		this.activeIngredientPerDose = prescriptionDTO.getActiveIngredientPerDose();
//		this.activeIngredientUnits = prescriptionDTO.getActiveIngredientUnits();
//		this.dosageNotes = prescriptionDTO.getDosageNotes();
//		this.activeIngredient = activeIngredient;
//		this.doctor = doctor;
//		this.patient = patient;
//		patient.addPrescription(this);
//		doctor.addPrescription(this);
//	}
