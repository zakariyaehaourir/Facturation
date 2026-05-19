package ma.ehei.facturation.controller;

import ma.ehei.facturation.dto.transaction.*;
import ma.ehei.facturation.exception.RemiseException;
import ma.ehei.facturation.exception.TransactionNotFoundException;
import ma.ehei.facturation.mapper.TransactionMapper;
import ma.ehei.facturation.service.FactureService;
import ma.ehei.facturation.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/transactions")
@Validated
public class TransactionController{

    private final FactureService factureService;
    private final TransactionService transactionService;
    public TransactionController(FactureService fs , TransactionService ts){
        this.factureService = fs;
        this.transactionService=ts;
    }

    @PostMapping()
    public ResponseEntity<CreateTransactionResponse> create(
            @RequestBody CreateTransactionRequest request
            , @RequestParam(defaultValue = "h2-database") String identifier)
    {
        var t =this.factureService.calculeMontant(request.getMontant() , identifier , request.getUser());
        URI location = URI.create("/api/v1/transactions/"+t.getId());
        return ResponseEntity.
                created(location).
                body(TransactionMapper.toCreateResponse(t)
        );

    }

    @GetMapping("{id}")
    public ResponseEntity<OneTransactionResponse> getOne(@PathVariable Long id){
       try{
           var t= this.transactionService.getById(id);
           return ResponseEntity.ok(
                   TransactionMapper.toDetailsTransaction(t)
           );
       }catch(TransactionNotFoundException ex) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }
    @PutMapping("{id}")
    public ResponseEntity<ErrorResponse> update(@RequestBody UpdateTransactionRequest request , @PathVariable Long id){
        if(!request.getId().equals(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        try{

            this.transactionService.updateTransaction(
                    TransactionMapper.toModel(request)
                    , id);
            return ResponseEntity.noContent().build();
        }catch(RemiseException ex){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(
                    new ErrorResponse()
                            .builder()
                            .message(ex.getMessage())
                            .build()
            );
        }catch(TransactionNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            this.transactionService.deleteTransaction(TransactionMapper.minimalisteModel(id));
            return ResponseEntity.noContent().build();
        }catch(TransactionNotFoundException ex){
            return ResponseEntity.notFound().build();
        }
    }
}
