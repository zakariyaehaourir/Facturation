CREATE TABLE remise (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        montant_min DECIMAL(10,2) NOT NULL,
                        montant_max DECIMAL(10,2) NULL,
                        taux DECIMAL(5,2)
);

INSERT INTO remise (montant_min, montant_max, taux) VALUES (0, 1000, 0.00);
INSERT INTO remise (montant_min, montant_max, taux) VALUES (1000, 5000, 0.05);
INSERT INTO remise (montant_min, montant_max, taux) VALUES (5000, 10000, 0.10);
INSERT INTO remise (montant_min, montant_max, taux) VALUES (10000, NULL, 0.15);


CREATE TABLE Transactions (


                             id             BIGINT    PRIMARY KEY AUTO_INCREMENT,


                             date           TIMESTAMP NOT NULL,



                             montant_avant  DOUBLE    NOT NULL,



                             montant_apres  DOUBLE    NOT NULL,



                             remise_id      BIGINT    REFERENCES Remise(id)


);