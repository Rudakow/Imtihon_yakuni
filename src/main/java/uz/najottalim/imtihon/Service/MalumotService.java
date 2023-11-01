package uz.najottalim.imtihon.Service;

import org.springframework.stereotype.Service;
import uz.najottalim.imtihon.Entitys.Malumot;
import uz.najottalim.imtihon.Repository.MalumotRypository;

import java.time.Year;
import java.util.NoSuchElementException;

@Service
public class MalumotService {

    private final MalumotRypository malumotRypository;

    public MalumotService(MalumotRypository malumotRypository) {
        this.malumotRypository = malumotRypository;
    }


    public Malumot save(Malumot malumot){
            return malumotRypository.save(malumot);
        }
        public boolean chekAge(Integer tugilgan_yili){
            return Year.now().getValue() - tugilgan_yili<20;
        }

        public Malumot updete(Long id,Malumot malumot){
            Malumot malumot1=malumotRypository.findById(id)
                    .orElseThrow(()->new NoSuchElementException("Xodim with ID " + id + " not found"));
            malumot1.setBolim(malumot.getBolim());
            malumot1.setLavozim(malumot.getLavozim());
            malumot1.setIsm(malumot.getIsm());
            malumot1.setFamiliya(malumot.getFamiliya());
            malumot1.setMaosh(malumot.getMaosh());

            return malumotRypository.save(malumot1);
        }
        public void deleteById(Long id){
            malumotRypository.deleteById(id);
        }
        public Malumot finById(Long id){
            return malumotRypository.findById(id)
                    .orElseThrow(()->new NoSuchElementException("Id = " + id + " Topilmadi"));
        }
    }
