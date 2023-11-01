package uz.najottalim.imtihon.Service;


import org.springframework.stereotype.Service;
import uz.najottalim.imtihon.Entitys.Bolim;
import uz.najottalim.imtihon.Entitys.Malumot;
import uz.najottalim.imtihon.Repository.BolimRepository;

import java.time.Year;
import java.util.NoSuchElementException;

@Service
public class BolimService {

    private final BolimRepository bolimRepository;

    public BolimService(BolimRepository bolimRepository) {
        this.bolimRepository = bolimRepository;
    }


    public Bolim save(Bolim bolim){
        return bolimRepository.save(bolim);
    }
    public boolean chekAge(Integer tugilgan_yili){
        return Year.now().getValue() - tugilgan_yili<20;
    }

    public Bolim updete(Long id,Bolim bolim){
        Bolim bolim1=bolimRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Xodim with ID " + id + " not found"));
        bolim1.setName(bolim.getName());
        return bolimRepository.save(bolim);
    }
    public void deleteById(Long id){
        bolimRepository.deleteById(id);
    }
    public Bolim finById(Long id){
        return bolimRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Id = " + id + " Topilmadi"));
    }
}

