package ReservationSystem.ReservationSystem.entity.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customers {

	
	@Column(name="id")
	private int id;
	
	@Id
	@Column(name="customer_id")
	private int customer_id;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@Column(name="customer_surname")
	private String customer_surname;
	
	@Column(name="e_mail")
	private String e_mail;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customers",fetch = FetchType.EAGER)
	private Reservations reservations;


	
	
	

}
