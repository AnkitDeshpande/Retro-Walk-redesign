package com.retrowalk.utility;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public <D, T> D convert(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    public <D, T> List<D> convert(List<T> entity, Class<D> outClass) {
        return entity.stream().map(e -> modelMapper.map(e, outClass)).toList();
    }

    public <D, T> Set<D> convert(Set<T> entity, Class<D> outClass) {
        return entity.stream().map(e -> modelMapper.map(e, outClass)).collect(Collectors.toSet());
    }
}
