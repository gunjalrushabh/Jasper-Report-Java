package com.alphaware.service.mapper;

import com.alphaware.domain.Address;
import com.alphaware.domain.Customer;
import com.alphaware.service.dto.AddressDTO;
import com.alphaware.service.dto.CustomerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(target = "customer", source = "customer", qualifiedByName = "customerCustomerId")
    AddressDTO toDto(Address s);

    @Named("customerCustomerId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "customerId", source = "customerId")
    CustomerDTO toDtoCustomerCustomerId(Customer customer);
}
