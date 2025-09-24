package springbootmybatis.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
	
	public static final long serialVersionUID = 6536563533333333L;

	private int pid;
	private String pname;
	private int page;
	
}
