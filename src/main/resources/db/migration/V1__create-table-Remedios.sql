create table Remedios(
    id bigserial not null,
    nome varchar(100) not null,
    via varchar(100) not null,
    lote varchar(100) not null,
    quantidade int not null,
    validade varchar(100) not null,
    laboratorio varchar(100) not null,
    primary key (id)
);
