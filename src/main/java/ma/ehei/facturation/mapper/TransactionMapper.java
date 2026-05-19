package ma.ehei.facturation.mapper;

import ma.ehei.facturation.dto.transaction.CreateTransactionResponse;
import ma.ehei.facturation.dto.transaction.OneTransactionResponse;
import ma.ehei.facturation.dto.transaction.UpdateTransactionRequest;
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

    public static Transaction toModel(UpdateTransactionRequest dto){
        return new Transaction().
                builder().
                id(dto.getId())
                        .montantApres(dto.getMontantApres())
                                .montantAvant(dto.getMontantAvant())
                                        .date(dto.getDate()).
                build();
    }

    public static Transaction minimalisteModel(Long id){
        return new Transaction()
                .builder()
                .id(id)
                .build();
    }
}
