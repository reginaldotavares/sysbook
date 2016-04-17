CREATE SEQUENCE usuario_seq;
CREATE SEQUENCE livro_seq;
CREATE SEQUENCE amizade_seq;
CREATE SEQUENCE autores_seq;
CREATE SEQUENCE grupo_seq;
CREATE SEQUENCE topico_seq;
CREATE SEQUENCE comentario_seq;


CREATE TABLE usuario
(
  id_usuario integer NOT NULL DEFAULT nextval('usuario_seq'::regclass),
  email character varying(60) NOT NULL UNIQUE,
  nome character varying(100) NOT NULL,
  apelido character varying(60) NOT NULL,
  senha character varying(30) NOT NULL,
  cidade character varying(30) NOT NULL,
  estado character varying(2) NOT NULL,
  foto character varying(200),
  dataNascimento character varying(30) NOT NULL,
  tipo boolean NOT NULL,

  CONSTRAINT usuario_pkey PRIMARY KEY (email)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario
  OWNER TO postgres;

 create table livro(
  id integer NOT NULL DEFAULT nextval('livro_seq'::regclass),
  isbn varchar(60) not null,
  titulo varchar(100) not null,
  anoPublicacao varchar (4) not null,
  editora varchar(60) not null,
  fotoCapa varchar(60),
  tema varchar(60),
  PRIMARY KEY (isbn)
);



create table grupo(
  id integer NOT NULL DEFAULT nextval('grupo_seq'::regclass) UNIQUE,
  emailUsuario varchar(30) NOT NULL,
  nome varchar(100) not null,
  descricao varchar (4) not null,
  PRIMARY KEY (id, emailUsuario),
  FOREIGN KEY (emailUsuario) REFERENCES usuario (email) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table amizade(
  id integer NOT NULL DEFAULT nextval('amizade_seq'::regclass),
  emailUsuario varchar(60) NOT NULL,
  emailAmigo varchar(60) NOT NULL,
  isAmigo boolean NOT NULL,
  since character varying(10) NOT NULL,
  PRIMARY KEY (emailUsuario, emailAmigo),
  FOREIGN KEY (emailUsuario) REFERENCES usuario (email) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (emailAmigo) REFERENCES usuario (email) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table autores(
  id integer NOT NULL DEFAULT nextval('autores_seq'::regclass),
  nomeAutor varchar(100) not null,
  isbnLivro varchar(60) not null,
  PRIMARY KEY (nomeAutor,isbnLivro),
  FOREIGN KEY (isbnLivro) REFERENCES livro (isbn) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table topico(
    id integer NOT NULL DEFAULT nextval('topico_seq'::regclass) UNIQUE,
    isbnLivro varchar(60) not NULL,
    idGrupo integer NOT NULL,
    title varchar(50) NOT NULL,
    PRIMARY KEY(isbnLivro, idGrupo),
    FOREIGN KEY (isbnLivro) REFERENCES livro (isbn) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (idGrupo) REFERENCES grupo (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

create table comentario(
  id integer NOT NULL DEFAULT nextval('comentario_seq'::regclass),
  id_topico integer NOT NULL,
  emailUsuario varchar(30) not null,
  descricao varchar(255) NOT NULL,
  PRIMARY KEY (id, id_topico, emailUsuario),
  FOREIGN KEY (id_topico) REFERENCES topico (id) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (emailUsuario) REFERENCES usuario (email) ON DELETE RESTRICT ON UPDATE CASCADE
);
