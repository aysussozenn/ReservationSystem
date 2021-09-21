package ReservationSystem.ReservationSystem.entity.concretes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","customers"})
public class Reservations {
	
	
	@Column(name = "id")
	private int id;
	
	@Id
	@Column(name = "customer_id")
	private int customer_id;
	
	@Column(name = "table_id")
	private int table_id;
	
	@JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
	@Column(name = "reservation_date")
	private LocalDate reservation_Date;
	
	@JsonFormat(pattern ="HH:mm:ss",shape =JsonFormat.Shape.STRING)
	@Column(name = "reservation_starting_time")
	private LocalTime res_starting_Time;
	
	@JsonFormat(pattern ="HH:mm:ss",shape =JsonFormat.Shape.STRING)
	@Column(name = "reservation_ending_time")
	private LocalTime res_ending_Time;
	
	@Column(name = "reserved")
	private boolean reserved;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customers customers;
	
	
	

}
