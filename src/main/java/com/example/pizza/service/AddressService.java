package com.example.pizza.service;


import com.example.pizza.model.Address;
import com.example.pizza.model.dto.AddressDto;
import com.example.pizza.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {


    private final AddressRepository addressRepository;

    // Создание адресса
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = ConvertAddressToDto(addressDto);
        addressRepository.save(address);
    return addressDto;
    }

    // Получение адресс по id
    public AddressDto getAddressId(UUID id) {
        Address address = addressRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        return ConvertDtoToAddress(address);
    }

    // Получение всех адрессов
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(this::ConvertDtoToAddress).collect(Collectors.toList());
    }

    // Обновление адресса
    public Address updateAddress(Address address) {
        return addressRepository.save(address);
    }

    //Удаление адресса
    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }

    private AddressDto ConvertDtoToAddress (Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setCustomer(address.getCustomer());
        return addressDto;
    }

    public Address ConvertAddressToDto (AddressDto addressDto){
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCustomer(addressDto.getCustomer());
        return address;
    }
}
