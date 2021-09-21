package ReservationSystem.ReservationSystem.entity.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tables")
@Entity
public class Tables {
	
	@Column(name = "id")
	private int id;
	
	@Id
	@Column(name = "table_id")
	private int table_id;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "reserved")
	private String reserved;
	
	@Column(name = "x")
	private double x;
	
	@Column(name = "y")
	private double y;
	
	@Column(name = "z")
	private int z;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tables", fetch = FetchType.LAZY)
	private List<TimeSlots> timeSlots;

	

	
	

}
