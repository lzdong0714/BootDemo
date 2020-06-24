package com.unicorn.unicornmultitest.chain.service.Impl;

import com.unicorn.unicornmultitest.chain.annot.ModelChain;
import com.unicorn.unicornmultitest.chain.enumm.Index;
import com.unicorn.unicornmultitest.chain.service.initService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月23日 11:20:00
 */


//@FunctionalInterface
//interface initService {
//
//    String init(int index, List<String> listStr);
//}
@Service
public class ProcessServiceA {


//    @ModelChain(index = Index.CHECK)
    public String processA(int index, List<String> list) {
        if(list == null || list.isEmpty()) return "empty process A";
        if(list.size() < index) return String.format("%02d", index);
        return list.get(index);
    }



//    @ModelChain(index = Index.HIDDEN)
    public String processB(int index, List<String> list) {
        if(list == null || list.isEmpty()) return "empty process B";
        if(list.size() < index) return String.format("%02d", index);
        return list.get(index);
    }


//    @ModelChain(index = Index.SHOW)
    public String processC(int index, List<String> list) {
        if(list == null || list.isEmpty()) return "empty process C";
        if(list.size() < index) return String.format("%02d", index);
        return list.get(index);
    }

    public initService initService(int index){
        switch (Index.values()[index]){
            case SHOW:return this::processA;
            case CHECK:return this::processB;
            case HIDDEN:return this::processC;
            default:return this::processA;
        }
    };

}


