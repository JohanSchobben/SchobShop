package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Address;
import iac.schobshop.Schobshop.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddressServiceImplTest {

    private AddressServiceImpl addressService;

    @Mock
    private AddressRepository addressRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        addressService = new AddressServiceImpl(addressRepository);
    }

    @Test
    public void findAdressByEmail() {
        Long addressId = 1L;
        String testMail  =  "test@Mail.com";
        Address address = new Address();
        address.setId(addressId);
        when(addressRepository.findAddressByAccount_Email(testMail)).thenReturn(address);
        Address addressResult = addressService.findAdressByEmail(testMail);
        assertEquals(address, addressResult);
        verify(addressRepository, times(1)).findAddressByAccount_Email(testMail);

    }

    @Test
    public void findAdressByEmailNull() {
        String testMail  =  "test@Mail.com";
        when(addressRepository.findAddressByAccount_Email(testMail)).thenReturn(null);
        Address addressResult = addressService.findAdressByEmail(testMail);
        assertNull(addressResult);
        verify(addressRepository, times(1)).findAddressByAccount_Email(testMail);


    }
}