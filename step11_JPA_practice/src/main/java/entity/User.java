package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class User {
	// id
	@Id
	private Long id;
	
	// name으로 사용하는데 length = 20
	@Column(columnDefinition = "varchar(20)")
	private String name;
	
	// length = 3자리까지가능하도록
	@Column(length = 3)
	private Integer age;
}
