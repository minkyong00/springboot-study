package springbootjpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSON")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
	
	public static final long serialVersionUID = 65526226262626L;

	@Id
	@SequenceGenerator(
		name = "SEQ_PERSON_GENERATE", // 시퀀스 제네레이터 이름
		sequenceName = "SEQ_PERSON", // 시퀀스 이름
		initialValue = 1, // 초기값
		allocationSize = 1 // 증가값
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERSON_GENERATE")
	private Long pid;
	
	@Column
	private String pname;
	
	@Column
	private int page;
	
}
