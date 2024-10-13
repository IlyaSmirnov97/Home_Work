package com.example.pizza.controller;

import com.example.pizza.model.Address;
import com.example.pizza.model.dto.AddressDto;
import com.example.pizza.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/addresses") // Базовый URL для всех маршрутов этого контроллера
public class AddressController {


    private final AddressService addressService; // Внедрение AddressService для обработки бизнес-логики

    // Создает новый адрес
    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        AddressDto createdAddress = addressService.createAddress(addressDto); // Сохранение адреса
        return ResponseEntity.ok(createdAddress); // Возврат созданного адреса
    }

    // Получает адрес по id
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable UUID id) {
        AddressDto address = addressService.getAddressId(id);
        return ResponseEntity.ok(address);
    }


    // Получает список всех адресов
    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok().body(addresses);
    }

    // Обновляет адрес по идентификатору
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody Address address) {
        address.setId(id); // Устанавливаем идентификатор адреса
        Address updatedAddress = addressService.updateAddress(address); // Обновление адреса
        return ResponseEntity.ok(updatedAddress); // Возврат обновленного адреса
    }

    // Удаляет адрес по идентификатору
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id); // Удаление адреса
        return ResponseEntity.noContent().build(); // Возврат 204 No Content
    }
}