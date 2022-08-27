create table tbl_product (
  product_id character varying(100) not null
  , product_name character varying(100) not null
  , price integer not null
  , imformation character varying(100)
  , model character varying(100)
  , category character varying(100) not null
  , brand character varying(100) not null
  , producing_area character varying(100) not null
  , stockpile_num integer not null
  , show_flg character varying(1) not null
  , del_flg character varying(1) not null
  , date_created timestamp(6) without time zone not null
  , date_modified timestamp(6) without time zone not null
  , primary key (product_id)
);
