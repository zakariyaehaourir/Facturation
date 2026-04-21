package ma.ehei.facturation.controller;

import ma.ehei.facturation.dto.Transaction.CreateTransactionResponse;
import ma.ehei.facturation.dto.Transaction.OneTransactionResponse;
import ma.ehei.facturation.exception.TransactionNotFoundException;
import ma.ehei.facturation.mapper.TransactionMapper;
import ma.ehei.facturation.service.FactureService;
import ma.ehei.facturation.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/transactions")
@Validated
public class TransactionController{

    private FactureService factureService;
    private TransactionService transactionService;
    public TransactionController(FactureService fs , TransactionService ts){
        this.factureService = fs;
        this.transactionService=ts;
    }

    @PostMapping()
    public ResponseEntity<CreateTransactionResponse> create(
            @RequestParam Double mt
            ,@RequestParam(defaultValue = "h2-database") String identifier)
    {
        var t =this.factureService.calculeMontant(mt , identifier);
        URI location = URI.create("/api/v1/transactions/"+t.getId());
        return ResponseEntity.
                created(location).
                body(TransactionMapper.toCreateResponse(t)
        );

    }

    @GetMapping("{id}")
    public ResponseEntity<OneTransactionResponse> getTransaction(@PathVariable Long id){
       try{
           var t= this.transactionService.getById(id);
           return ResponseEntity.ok(
                   TransactionMapper.toDetailsTransaction(t)
           );
       }catch(TransactionNotFoundException ex){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }

    }
}
