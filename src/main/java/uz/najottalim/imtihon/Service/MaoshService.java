package uz.najottalim.imtihon.Service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import uz.najottalim.imtihon.Entitys.Malumot;
import uz.najottalim.imtihon.Entitys.Maosh;
import uz.najottalim.imtihon.Repository.MalumotRypository;
import uz.najottalim.imtihon.Repository.MaoshRepository;

import java.time.Year;
import java.util.NoSuchElementException;

@Service
public class MaoshService {
    private final MalumotRypository malumotRypository;
    private final MaoshRepository maoshRepository;

    public MaoshService(MalumotRypository malumotRypository, MaoshRepository maoshRepository) {
        this.malumotRypository = malumotRypository;
        this.maoshRepository = maoshRepository;
    }

    public Maosh save(Maosh maosh){
        return maoshRepository.save(maosh);
    }
    public boolean chekAge(Integer tugilgan_yili){
        return Year.now().getValue() - tugilgan_yili<20;
    }
    public void deleteById(Long id){
        maoshRepository.deleteById(id);
    }
    public Maosh finById(Long id){
        return maoshRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Id = " + id + " Topilmadi"));
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

