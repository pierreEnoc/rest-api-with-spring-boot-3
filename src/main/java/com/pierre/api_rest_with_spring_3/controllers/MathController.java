package com.pierre.api_rest_with_spring_3.controllers;


import com.pierre.api_rest_with_spring_3.converter.request.NumberConverter;
import com.pierre.api_rest_with_spring_3.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
           @PathVariable("numberOne") String numberOne,
           @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value! ");
      return math.sum(NumberConverter.converToDoube(numberOne), NumberConverter.converToDoube(numberTwo));
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double Sub(
          @PathVariable("numberOne")  String numberOne,
          @PathVariable("numberTwo")  String numberTwo
    )throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return math.sub(NumberConverter.converToDoube(numberOne), NumberConverter.converToDoube(numberTwo));
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne")  String numberOne,
            @PathVariable("numberTwo")  String numberTwo
    )throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return math.div(NumberConverter.converToDoube(numberOne), NumberConverter.converToDoube(numberTwo));
    }

    @RequestMapping("/multi/{numberOne}/{numberTwo}")
    public Double multi(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return math.multi(NumberConverter.converToDoube(numberOne), (NumberConverter.converToDoube(numberTwo)));
    }

    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double media(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedOperationException("Please set a numeric value!");
        return math.mean(NumberConverter.converToDoube(numberOne) , (NumberConverter.converToDoube(numberTwo)));
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareroot(
            @PathVariable("number") String number
    )throws Exception {
        if(!NumberConverter.isNumeric(number))throw new UnsupportedOperationException("Please set a numeric value!");
        //Double result = Math.sqrt(convertoDoube(number));
        //return result;
        return math.squareroot(NumberConverter.converToDoube(number));
    }

}
