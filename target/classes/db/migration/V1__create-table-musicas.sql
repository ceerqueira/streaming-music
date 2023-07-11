create table musicas(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    artista varchar(100) not null,
    album varchar(6) not null,
    duracao varchar(100) not null,

    primary key(id)

);