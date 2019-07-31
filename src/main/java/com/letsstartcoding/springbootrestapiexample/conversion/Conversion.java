package com.letsstartcoding.springbootrestapiexample.conversion;


import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.dao.TransactionDAO;
import com.letsstartcoding.springbootrestapiexample.dto.PassbookDTO;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Conversion {

    List<PassbookDTO>passbookDTOS = new ArrayList<PassbookDTO>();

    public List<PassbookDTO> call(List<Transactions>transL, List<Transactions>transL1,Integer balance){

        if(!transL.isEmpty()){
            PassbookDTO passbookDTO = new PassbookDTO();
            passbookDTO.setType("Send");
            passbookDTO.setTrans(transL);
            passbookDTO.setBalance(balance);
            passbookDTOS.add(passbookDTO);
            System.out.println("helo");
        }

        if(!transL1.isEmpty()){
            PassbookDTO passbookDTO = new PassbookDTO();
            passbookDTO.setType("Receive");
            passbookDTO.setTrans(transL1);
            passbookDTO.setBalance(balance);
            passbookDTOS.add(passbookDTO);
        }

        return passbookDTOS;
    }
}
