package springbootsecurity.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

	public static final long serialVersionUID = 5645645646546465L;
	
	@Id
	@SequenceGenerator(
		name = "seq_member_generator", 
		sequenceName = "SEQ_MEMBER",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "seq_member_generator"
	)
	private Long id; 
	
	@Column(unique = true, nullable = false, length = 50)
	private String username;
	
	@Column(nullable = false, length = 200)
	private String password;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 20)
	private String role;
	
	private LocalDateTime regdate = LocalDateTime.now();
	
}































