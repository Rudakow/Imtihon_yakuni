package uz.najottalim.imtihon.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.imtihon.Entitys.Malumot;
import uz.najottalim.imtihon.Repository.MalumotRypository;
import uz.najottalim.imtihon.Repository.MaoshRepository;

@Service
public class Keldi_keti {
    private final MalumotRypository malumotRypository;
    private final MaoshRepository maoshRepository;

    public Keldi_keti(MalumotRypository malumotRypository, MaoshRepository maoshRepository) {
        this.malumotRypository = malumotRypository;
        this.maoshRepository = maoshRepository;
    }

    public Malumot ishgaKirish(Malumot malumot) {
        malumot.ishgaKiring();
        return malumotRypository.save(malumot);
    }
    public Malumot ishniTugatish(Long malumotId) {
        Malumot malumot = malumotRypository.findById(malumotId)
                .orElseThrow(() -> new EntityNotFoundException("Id " + malumotId + "ishchi topilmadi"));
        malumot.ishniTugating();
        return malumotRypository.save(malumot);
    }



}

