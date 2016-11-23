package net.jianbo.sample.service.mapper;

import net.jianbo.sample.domain.*;
import net.jianbo.sample.service.dto.MerchantDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Merchant and its DTO MerchantDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MerchantMapper {

    MerchantDTO merchantToMerchantDTO(Merchant merchant);

    List<MerchantDTO> merchantsToMerchantDTOs(List<Merchant> merchants);

    Merchant merchantDTOToMerchant(MerchantDTO merchantDTO);

    List<Merchant> merchantDTOsToMerchants(List<MerchantDTO> merchantDTOs);
}
