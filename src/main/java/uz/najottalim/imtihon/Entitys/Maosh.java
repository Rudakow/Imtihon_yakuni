package uz.najottalim.imtihon.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maosh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double minut;
    double soat;
    double kun;
    double hafta;
    double oy;
    double maosh;
    double yoq_maosh;

    @ManyToOne
    @JoinColumn(name = "malumot_id")
    private Malumot malumot;
}
