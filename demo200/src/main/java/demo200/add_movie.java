package demo200;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class add_movie {
	@Id
	private String mname;
	private String description;
	@Lob
	private byte[] mimage;
	private String mlanguage;
	private int mrating;

}
