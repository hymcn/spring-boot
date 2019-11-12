package mooon.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrator
 * @date 2019/11/11.
 */
@Entity
@Getter
@Setter
@ToString
public class Billionaires {

	@Id
	private Integer id;
	private String first_name;
	private String last_name;
	private String career;
}
