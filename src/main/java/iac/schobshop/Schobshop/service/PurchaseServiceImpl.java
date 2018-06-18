package iac.schobshop.Schobshop.service;

import iac.schobshop.Schobshop.model.Purchase;
import iac.schobshop.Schobshop.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void savePurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}
