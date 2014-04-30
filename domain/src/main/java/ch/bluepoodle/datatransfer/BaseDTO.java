package ch.bluepoodle.datatransfer;

import java.io.Serializable;


public abstract class BaseDTO implements Serializable {
	private static final long serialVersionUID = 1753050474967278100L;
	private Long id;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		BaseDTO other = (BaseDTO) object;
		if (this.getId() != other.getId()
				&& (this.getId() == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
}
