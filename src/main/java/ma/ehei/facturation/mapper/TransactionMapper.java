package ma.ehei.facturation.mapper;

import ma.ehei.facturation.dto.Transaction.CreateTransactionResponse;
import ma.ehei.facturation.dto.Transaction.OneTransactionResponse;
import ma.ehei.facturation.model.Transaction;

public class TransactionMapper {
    public static CreateTransactionResponse toCreateResponse(Transaction model){
        return new CreateTransactionResponse()
                .builder()
                .id(model.getId())
                .date(model.getDate())
                .montantAvant(model.getMontantAvant())
                .montantApres(model.getMontantApres())
                .build();
    }

    public static OneTransactionResponse toDetailsTransaction(Transaction t){
        return OneTransactionResponse.builder()
                .date(t.getDate())
                .montantApres(t.getMontantApres())
                .montantAvant(t.getMontantAvant())
                .build();
    }
}
