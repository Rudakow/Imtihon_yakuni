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
    BigDecimal maosh;
    BigDecimal yoq_maosh;

    @ManyToOne
    @JoinColumn(name = "malumot_id")
    private Malumot malumot;

    public static BigDecimal HaftaliMaosh(BigDecimal oy) {
        BigDecimal weeksInAMonth = new BigDecimal("4");
        return oy.divide(weeksInAMonth, 2, BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal KunMaosh(BigDecimal monthlySalary) {
        BigDecimal daysInAMonth = new BigDecimal("30");
        return monthlySalary.divide(daysInAMonth, 2, BigDecimal.ROUND_HALF_UP);
    }
    public static BigDecimal SoatliMaosh(BigDecimal monthlySalary) {
        BigDecimal hoursInADay = new BigDecimal("24");
        BigDecimal daysInAWeek = new BigDecimal("7");
        BigDecimal weeksInAMonth = new BigDecimal("4");
        BigDecimal hoursInAWeek = hoursInADay.multiply(daysInAWeek);
        return monthlySalary.divide(hoursInAWeek.multiply(weeksInAMonth), 2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal MinutMaosh(BigDecimal monthlySalary) {
        BigDecimal hoursInADay = new BigDecimal("24");
        BigDecimal minutesInAnHour = new BigDecimal("60");
        return monthlySalary.divide(hoursInADay.multiply(minutesInAnHour).multiply(new BigDecimal("4")), 2, BigDecimal.ROUND_HALF_UP);
    }
}
