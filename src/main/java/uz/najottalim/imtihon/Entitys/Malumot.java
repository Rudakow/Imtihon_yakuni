package uz.najottalim.imtihon.Entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Malumot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ism;
    private String familiya;
    private LocalDate tugilganYil;
     BigDecimal maosh;
    private LocalDateTime ishgaKelganVaqt;
    private LocalDateTime ishdaVaqtTugagan;

    @ManyToOne
    @JoinColumn(name = "bolim_id")
    private Bolim bolim;

    @ManyToOne
    @JoinColumn(name = "lavozim_id")
    private Lavozim lavozim;
    public void ishgaKiring() {
        ishgaKelganVaqt = LocalDateTime.now();
    }

    public void ishniTugating() {
        ishdaVaqtTugagan = LocalDateTime.now();
    }

}
