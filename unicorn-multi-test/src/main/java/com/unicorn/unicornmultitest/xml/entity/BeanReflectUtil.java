package com.unicorn.unicornmultitest.xml.entity;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年07月16日 17:15:00
 */
public class BeanReflectUtil {
    /**
     *
     *  use recursive to obtain the value of property by bean model name and property
     *
     */

    private static EmrVO fetchExampleModel(){
        EmrVO emrVO = new EmrVO();
        Patient patient = new Patient();
        Medicine medicine = new Medicine();
        Check check = new Check();
        emrVO.setPatient(patient);
        emrVO.setCheck(check);
        emrVO.setMedicine(medicine);
        medicine.setId(1);
        medicine.setPrice(10.0f);
        medicine.setQuantity(10);
        medicine.setMedName("哇哈哈");
        medicine.setMedType(0);
        patient.setId(1L);
        patient.setAge(20);
        patient.setName("王力宏");
        patient.setSex(1);
        check.setCheckName("喝水");
        check.setCheckType(1);
        check.setId(1);
        check.setPrice(8.99f);
        check.setQuantity(60);
        return emrVO;
    }


}
