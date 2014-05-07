create table public.journal (
  id                        bigint not null,
  shortname                 varchar(255),
  name                      varchar(255),
  constraint pk_journal primary key (id))
;

create table public.reference (
  id                        bigint not null,
  first                     varchar(255),
  year                      integer,
  volume                    varchar(255),
  pages                     varchar(255),
  medline                   varchar(255),
  pmid                      varchar(255),
  title                     varchar(255),
  authors                   varchar(255),
  journal_id                bigint,
  constraint pk_reference primary key (id))
;

create sequence public.journal_seq;

create sequence public.reference_seq;

alter table public.reference add constraint fk_public.reference_journal_1 foreign key (journal_id) references public.journal (id);
create index ix_public.reference_journal_1 on public.reference (journal_id);


