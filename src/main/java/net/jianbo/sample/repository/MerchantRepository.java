package net.jianbo.sample.repository;

import net.jianbo.sample.domain.Merchant;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Merchant entity.
 */
@SuppressWarnings("unused")
public interface MerchantRepository extends JpaRepository<Merchant,Long> {

}
