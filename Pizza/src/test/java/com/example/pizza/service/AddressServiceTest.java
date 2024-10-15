package com.example.pizza.service;

import com.example.pizza.model.Address;
import com.example.pizza.model.dto.AddressDto;
import com.example.pizza.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    private AddressDto addressDto;
    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addressDto = new AddressDto();
        addressDto.setId(UUID.randomUUID());
        addressDto.setStreet("123 Main St");
        addressDto.setCity("Springfield");
        addressDto.setState("IL");
        addressDto.setPostalCode("62701");

        address = new Address();
        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPostalCode(addressDto.getPostalCode());
    }

    @Test
    void createAddress() {
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        AddressDto createdAddressDto = addressService.createAddress(addressDto);

        assertNotNull(createdAddressDto);
        assertEquals(addressDto.getId(), createdAddressDto.getId());
        assertEquals(addressDto.getStreet(), createdAddressDto.getStreet());
        verify(addressRepository, times(1)).save(any(Address.class));
    }

    @Test
    void getAddressId() {
        when(addressRepository.findById(any(UUID.class))).thenReturn(Optional.of(address));

        AddressDto foundAddressDto = addressService.getAddressId(addressDto.getId());

        assertNotNull(foundAddressDto);
        assertEquals(addressDto.getId(), foundAddressDto.getId());
        verify(addressRepository, times(1)).findById(any(UUID.class));
    }

    @Test
    void getAllAddresses() {
        when(addressRepository.findAll()).thenReturn(Collections.singletonList(address));

        List<AddressDto> addressDtoList = addressService.getAllAddresses();

        assertNotNull(addressDtoList);
        assertEquals(1, addressDtoList.size());
        assertEquals(addressDto.getId(), addressDtoList.get(0).getId());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void updateAddress() {
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address updatedAddress = addressService.updateAddress(address);

        assertNotNull(updatedAddress);
        assertEquals(address.getId(), updatedAddress.getId());
        verify(addressRepository, times(1)).save(any(Address.class));
    }

    @Test
    void deleteAddress() {
        UUID addressId = addressDto.getId();
        doNothing().when(addressRepository).deleteById(addressId);

        addressService.deleteAddress(addressId);

        verify(addressRepository, times(1)).deleteById(addressId);
    }

    @Test
    void getAddressIdNotFound() {
        when(addressRepository.findById(any(UUID.class))).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            addressService.getAddressId(addressDto.getId());
        });

        assertEquals("Not found", thrown.getMessage());
    }
}
