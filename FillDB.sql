DB: PostgreSQL

-- Table: public.account

-- DROP TABLE public.account;

CREATE TABLE public.account
(
  account_id integer NOT NULL DEFAULT nextval('account_account_id_seq'::regclass),
  login character varying(255),
  mail character varying(255),
  password character varying(255),
  address_id integer,
  CONSTRAINT account_pkey PRIMARY KEY (account_id),
  CONSTRAINT fk_q4mt85fqye0pwgamg8vlw8mrb FOREIGN KEY (address_id)
      REFERENCES public.address (address_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.account
  OWNER TO postgres;

-- Table: public.account_roles

-- DROP TABLE public.account_roles;

CREATE TABLE public.account_roles
(
  account_id integer NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT account_roles_pkey PRIMARY KEY (account_id, role_id),
  CONSTRAINT fk_2hoo7dauoddd6w4j7ybaa6k90 FOREIGN KEY (role_id)
      REFERENCES public.roles (role_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_cgiq4c38ilthc7m6260xyynxb FOREIGN KEY (account_id)
      REFERENCES public.account (account_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.account_roles
  OWNER TO postgres;

-- Table: public.address

-- DROP TABLE public.address;

CREATE TABLE public.address
(
  address_id integer NOT NULL DEFAULT nextval('address_address_id_seq'::regclass),
  flat_number integer,
  house_number integer,
  street character varying(255),
  CONSTRAINT address_pkey PRIMARY KEY (address_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.address
  OWNER TO postgres;

-- Table: public.bonus_card

-- DROP TABLE public.bonus_card;

CREATE TABLE public.bonus_card
(
  card_id integer NOT NULL DEFAULT nextval('bonus_card_card_id_seq'::regclass),
  bonus_size double precision,
  CONSTRAINT bonus_card_pkey PRIMARY KEY (card_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.bonus_card
  OWNER TO postgres;

-- Table: public.customers

-- DROP TABLE public.customers;

CREATE TABLE public.customers
(
  customer_id integer NOT NULL DEFAULT nextval('customers_customer_id_seq'::regclass),
  account_id integer,
  card_id integer,
  CONSTRAINT customers_pkey PRIMARY KEY (customer_id),
  CONSTRAINT fk_4njtl3pvfduamug24b9qmpy0x FOREIGN KEY (account_id)
      REFERENCES public.account (account_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ljy36x1byyabm4xlt61vsyy30 FOREIGN KEY (card_id)
      REFERENCES public.bonus_card (card_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.customers
  OWNER TO postgres;

-- Table: public.order_details

-- DROP TABLE public.order_details;

CREATE TABLE public.order_details
(
  order_detail_id integer NOT NULL DEFAULT nextval('order_details_order_detail_id_seq'::regclass),
  pizza_quantity integer,
  order_id integer,
  pizza_id integer,
  CONSTRAINT order_details_pkey PRIMARY KEY (order_detail_id),
  CONSTRAINT fk_fwu46f68bquggju5f61dviqey FOREIGN KEY (pizza_id)
      REFERENCES public.pizza (pizza_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_p387c2pa1m3xxcxcktoawo954 FOREIGN KEY (order_id)
      REFERENCES public.orders (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.order_details
  OWNER TO postgres;

-- Table: public.orders

-- DROP TABLE public.orders;

CREATE TABLE public.orders
(
  order_id integer NOT NULL DEFAULT nextval('orders_order_id_seq'::regclass),
  price double precision,
  ordersize integer,
  status character varying(255),
  customer_id integer,
  CONSTRAINT orders_pkey PRIMARY KEY (order_id),
  CONSTRAINT fk_astys1dv61mdlp0n0wx0574r2 FOREIGN KEY (customer_id)
      REFERENCES public.customers (customer_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.orders
  OWNER TO postgres;

-- Table: public.pizza

-- DROP TABLE public.pizza;

CREATE TABLE public.pizza
(
  pizza_id integer NOT NULL DEFAULT nextval('pizza_pizza_id_seq'::regclass),
  name character varying(255),
  type character varying(255),
  price double precision,
  CONSTRAINT pizza_pkey PRIMARY KEY (pizza_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pizza
  OWNER TO postgres;

-- Table: public.roles

-- DROP TABLE public.roles;

CREATE TABLE public.roles
(
  role_id integer NOT NULL DEFAULT nextval('roles_role_id_seq'::regclass),
  name character varying(255),
  CONSTRAINT roles_pkey PRIMARY KEY (role_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.roles
  OWNER TO postgres;

INSERT INTO "public".pizza
	( name, type, price)
	VALUES ( 'Barbecue', 'MEAT', 119 ),
	       ( 'Margaret', 'VEGETARIAN', 119 ),
	       ( 'Tuna', 'SEA', 175 ),
	       ( 'Texas', 'MEAT', 119 ),
	       ( 'Hawaiian', 'HAWAIIAN', 153 ),
	       ( 'Bavarian', 'MEAT', 119 ),
	       ( 'Spinach and Feta', 'VEGETARIAN', 119 );	
		   
INSERT INTO "public".roles
	( name )
	VALUES ( 'ADMIN' ),
	       ('USER');

INSERT INTO "public".account
	( account_id, login, mail, password )
	VALUES ( 2, admin, admin@gmail.com, admin )
	
INSERT INTO "public".account_roles
	( account_id, role_id )
	VALUES ( 2, 1 )