package net.jianbo.sample.service;

import net.jianbo.sample.service.dto.MerchantDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;

/**
 * Service Interface for managing Merchant.
 */
public interface MerchantService {

    /**
     * Save a merchant.
     *
     * @param merchantDTO the entity to save
     * @return the persisted entity
     */
    MerchantDTO save(MerchantDTO merchantDTO);

    /**
     *  Get all the merchants.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<MerchantDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" merchant.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    MerchantDTO findOne(Long id);

    /**
     *  Delete the "id" merchant.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
