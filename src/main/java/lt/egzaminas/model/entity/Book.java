package lt.egzaminas.model.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
/**
 * Entity representing books
 *
 */
	public class Book {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
//		@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//		@JoinColumn(name = "BOOK_ID", nullable = false)
		private Long id;

		@Column(name = "BOOK_TITLE", length = 8000)
		private String title;
		
		@Column(name = "BOOK_AUTHOR", length = 8000)
		private String author;
		
		@Column(name = "PRICE", length = 8000)
		private BigDecimal price;
		
		@Column(name = "QUANTITY", length = 8000)
		private Long quantity;
		
		@Column(name = "PAGE_NUM", length = 8000)
		private int pageNum;

	}


