package com.pierre.api_rest_with_spring_3.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    //Mappera Entidade -> DTO
    //Dto -> Entidade
  private  static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

  public static <O, D> D parseObjects(O origin, Class<D> destination) {
      return mapper.map(origin, destination);
  }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {

      List<D> destinationObjects = new ArrayList<D> ();
      for (Object o : origin ) {
       destinationObjects.add(mapper.map(o, destination));
      }
        return destinationObjects;
    }

}
