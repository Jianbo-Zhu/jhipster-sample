package net.jianbo.sample.service.impl;

import net.jianbo.sample.service.MerchantService;
import net.jianbo.sample.domain.Merchant;
import net.jianbo.sample.repository.MerchantRepository;
import net.jianbo.sample.service.dto.MerchantDTO;
import net.jianbo.sample.service.mapper.MerchantMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Merchant.
 */
@Service
@Transactional
public class MerchantServiceImpl implements MerchantService{

    private final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);
    
    @Inject
    private MerchantRepository merchantRepository;

    @Inject
    private MerchantMapper merchantMapper;

    /**
     * Save a merchant.
     *
     * @param merchantDTO the entity to save
     * @return the persisted entity
     */
    public MerchantDTO save(MerchantDTO merchantDTO) {
        log.debug("Request to save Merchant : {}", merchantDTO);
        Merchant merchant = merchantMapper.merchantDTOToMerchant(merchantDTO);
        merchant = merchantRepository.save(merchant);
        MerchantDTO result = merchantMapper.merchantToMerchantDTO(merchant);
        return result;
    }

    /**
     *  Get all the merchants.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<MerchantDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Merchants");
        Page<Merchant> result = merchantRepository.findAll(pageable);
        return result.map(merchant -> merchantMapper.merchantToMerchantDTO(merchant));
    }

    /**
     *  Get one merchant by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public MerchantDTO findOne(Long id) {
        log.debug("Request to get Merchant : {}", id);
        Merchant merchant = merchantRepository.findOne(id);
        MerchantDTO merchantDTO = merchantMapper.merchantToMerchantDTO(merchant);
        return merchantDTO;
    }

    /**
     *  Delete the  merchant by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Merchant : {}", id);
        merchantRepository.delete(id);
    }
}
