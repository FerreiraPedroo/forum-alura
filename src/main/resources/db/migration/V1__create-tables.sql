
create table perfil(
   id int not null AUTO_INCREMENT,
   nome varchar(50) not null,

   primary key(id)
);

create table usuarios(
   id int not null AUTO_INCREMENT,
   nome varchar(50) not null,
   email varchar(50) not null,
   senha varchar(50) not null,
   perfil_id int not null,

   primary key(id),
   foreign key (perfil_id) references perfil(id)
);


create table cursos(
   id int not null AUTO_INCREMENT,
   nome varchar(50) not null,
   categoria varchar(255) not null,

   primary key(id)
);


create table topicos(
    id int not null AUTO_INCREMENT,
    titulo varchar(255) not null,
    mensagem text not null,
    data_criacao timestamp not null,
    status varchar(20),
    autor_id int not null,
    curso_id int not null,
    respostas_id int,

    primary key(id),
    foreign key (autor_id) references usuarios(id),
    foreign key (curso_id) references cursos(id)
);


create table respostas(
    id int not null AUTO_INCREMENT,
    mensagem text not null,
    topico_id int not null,
    data_criacao timestamp not null,
    autor_id int not null,
    solucao tinyint(1) DEFAULT 0,

    primary key(id),
    foreign key (topico_id) references topicos(id),
    foreign key (autor_id) references usuarios(id)
);

