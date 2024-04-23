--
-- PostgreSQL database dump
--

-- Dumped from database version 12.18 (Debian 12.18-1.pgdg120+2)
-- Dumped by pg_dump version 12.14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_table_access_method = heap;

--
-- Name: tb_categories; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_categories (
    id bigint NOT NULL,
    name character varying(255)
);


--
-- Name: tb_categories_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_categories_id_seq OWNED BY public.tb_categories.id;


--
-- Name: tb_oder_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_oder_item (
    price double precision,
    quantity integer,
    product_id bigint NOT NULL,
    order_id bigint NOT NULL
);


--
-- Name: tb_orders; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_orders (
    id bigint NOT NULL,
    moment timestamp(6) with time zone,
    order_status character varying(255),
    client_id bigint
);


--
-- Name: tb_orders_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_orders_id_seq OWNED BY public.tb_orders.id;


--
-- Name: tb_payments; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_payments (
    moment timestamp(6) with time zone,
    order_id bigint NOT NULL
);


--
-- Name: tb_product_category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_product_category (
    product_id bigint NOT NULL,
    category_id bigint NOT NULL
);


--
-- Name: tb_products; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_products (
    id bigint NOT NULL,
    description character varying(255),
    imageurl character varying(255),
    name character varying(255),
    price double precision
);


--
-- Name: tb_products_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_products_id_seq OWNED BY public.tb_products.id;


--
-- Name: tb_users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_users (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255),
    phone character varying(255)
);


--
-- Name: tb_users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: tb_users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_users_id_seq OWNED BY public.tb_users.id;


--
-- Name: tb_categories id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_categories ALTER COLUMN id SET DEFAULT nextval('public.tb_categories_id_seq'::regclass);


--
-- Name: tb_orders id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_orders ALTER COLUMN id SET DEFAULT nextval('public.tb_orders_id_seq'::regclass);


--
-- Name: tb_products id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_products ALTER COLUMN id SET DEFAULT nextval('public.tb_products_id_seq'::regclass);


--
-- Name: tb_users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_users ALTER COLUMN id SET DEFAULT nextval('public.tb_users_id_seq'::regclass);


--
-- Name: tb_categories tb_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_categories
    ADD CONSTRAINT tb_categories_pkey PRIMARY KEY (id);


--
-- Name: tb_oder_item tb_oder_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_oder_item
    ADD CONSTRAINT tb_oder_item_pkey PRIMARY KEY (order_id, product_id);


--
-- Name: tb_orders tb_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_orders
    ADD CONSTRAINT tb_orders_pkey PRIMARY KEY (id);


--
-- Name: tb_payments tb_payments_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_payments
    ADD CONSTRAINT tb_payments_pkey PRIMARY KEY (order_id);


--
-- Name: tb_product_category tb_product_category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT tb_product_category_pkey PRIMARY KEY (product_id, category_id);


--
-- Name: tb_products tb_products_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_products
    ADD CONSTRAINT tb_products_pkey PRIMARY KEY (id);


--
-- Name: tb_users tb_users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_users
    ADD CONSTRAINT tb_users_pkey PRIMARY KEY (id);


--
-- Name: tb_payments fk59gb66nuu5bq1hjeg2og3fi45; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_payments
    ADD CONSTRAINT fk59gb66nuu5bq1hjeg2og3fi45 FOREIGN KEY (order_id) REFERENCES public.tb_orders(id);


--
-- Name: tb_oder_item fk8xrw8ha8mnvq1thn7ujdsk095; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_oder_item
    ADD CONSTRAINT fk8xrw8ha8mnvq1thn7ujdsk095 FOREIGN KEY (product_id) REFERENCES public.tb_products(id);


--
-- Name: tb_product_category fkeaxc016dqii836yl4ue7ev8j5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT fkeaxc016dqii836yl4ue7ev8j5 FOREIGN KEY (category_id) REFERENCES public.tb_categories(id);


--
-- Name: tb_orders fkjbtk96a5pyaj3qx3bmgvghksg; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_orders
    ADD CONSTRAINT fkjbtk96a5pyaj3qx3bmgvghksg FOREIGN KEY (client_id) REFERENCES public.tb_users(id);


--
-- Name: tb_oder_item fkp94p2xiuwnf8rdrejf48sdkjc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_oder_item
    ADD CONSTRAINT fkp94p2xiuwnf8rdrejf48sdkjc FOREIGN KEY (order_id) REFERENCES public.tb_orders(id);


--
-- Name: tb_product_category fkq8plupmr9wr1q1vy31m9b0v90; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT fkq8plupmr9wr1q1vy31m9b0v90 FOREIGN KEY (product_id) REFERENCES public.tb_products(id);


--
-- PostgreSQL database dump complete
--

