package springbootthymeleaf.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {
	
	public static final long serialVersionUID = 6565656565L;

	private String name;
	private int age;
	
}