package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "departure_point", nullable = false)
    private String departurePoint;

    @Column(name = "arrival_point", nullable = false)
    private String arrivalPoint;

    @Column(name = "departure_time", nullable = false)
    private Timestamp departureTime;

    @Column(name = "arrival_time", nullable = false)
    private Timestamp arrivalTime;
}