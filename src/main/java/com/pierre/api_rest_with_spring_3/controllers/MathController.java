package com.pierre.api_rest_with_spring_3.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value! ");
      return convertoDoube(numberOne) + convertoDoube(numberTwo);
    }

    private Double convertoDoube(String strnumber) {

        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value! ");
        String number = strnumber.replace(",",".");//R$5,00 USD 5.00
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strnumber) {
        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedOperationException("Please set a numeric value! ");
        String number = strnumber.replace(",",".");//R$5,00 USD 5.00
       return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double Sub(
          @PathVariable("numberOne")  String numberOne,
          @PathVariable("numberTwo")  String numberTwo
    )throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertoDoube(numberOne) - convertoDoube(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne")  String numberOne,
            @PathVariable("numberTwo")  String numberTwo
    )throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertoDoube(numberOne) / convertoDoube(numberTwo);
    }

    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return convertoDoube(numberOne) * (convertoDoube(numberTwo));
    }

}
