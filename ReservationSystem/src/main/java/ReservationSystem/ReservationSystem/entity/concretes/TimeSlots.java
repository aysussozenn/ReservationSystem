package ReservationSystem.ReservationSystem.entity.concretes;

import java.sql.Time;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ReservationSystem.ReservationSystem.core.utilities.DataResults;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "time_slots")


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","tables"})
public class TimeSlots {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private int id;

	@Column(name="table_id",nullable = false)
	private int table_id;
	
	@JsonFormat(pattern ="HH:mm:ss",shape =JsonFormat.Shape.STRING)
	@Column(name = "available_starting_time")
	private LocalTime available_starting_time;
	

	
	@JsonFormat(pattern ="HH:mm:ss",shape =JsonFormat.Shape.STRING)
	@Column(name = "available_ending_time")
	private LocalTime available_ending_time;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="table_id",referencedColumnName = "table_id",insertable = false,updatable = false)
	private Tables tables;

}
