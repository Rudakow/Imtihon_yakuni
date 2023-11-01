package uz.najottalim.imtihon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.najottalim.imtihon.Entitys.Lavozim;
import uz.najottalim.imtihon.Entitys.Malumot;

import java.util.Optional;


public interface MalumotRypository extends JpaRepository<Malumot, Long> {
}
