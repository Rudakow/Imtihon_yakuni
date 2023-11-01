package uz.najottalim.imtihon.Service;

import org.springframework.stereotype.Service;
import uz.najottalim.imtihon.Entitys.Lavozim;
import uz.najottalim.imtihon.Repository.LavozimRepository;

import java.time.Year;
import java.util.NoSuchElementException;
@Service

public class LavozimService {




    private final LavozimRepository lavozimRepository;

    public LavozimService(LavozimRepository lavozimRepository) {
        this.lavozimRepository = lavozimRepository;
    }


    public Lavozim save(Lavozim lavozim){
        return lavozimRepository.save(lavozim);
    }
    public boolean chekAge(Integer tugilgan_yili){
        return Year.now().getValue() - tugilgan_yili<20;
    }

    public Lavozim updete(Long id,Lavozim lavozim){
        Lavozim lavozim1=lavozimRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Xodim with ID " + id + " not found"));
                lavozim1.setName(lavozim.getName());
        return lavozimRepository.save(lavozim1);
    }
    public void deleteById(Long id){
        lavozimRepository.deleteById(id);
    }
    public Lavozim finById(Long id){
        return lavozimRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Id = " + id + " Topilmadi"));
    }
}
