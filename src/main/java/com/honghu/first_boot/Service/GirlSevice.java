package com.honghu.first_boot.Service;

import com.honghu.first_boot.entity.Girl;
import com.honghu.first_boot.repo.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlSevice {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void InsertTwo(){
        Girl girl = new Girl();
        girl.setAge(22);
        girl.setCupSize("a");
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setAge(25);
        girl2.setCupSize("t");
        girlRepository.save(girl2);
    }

}
